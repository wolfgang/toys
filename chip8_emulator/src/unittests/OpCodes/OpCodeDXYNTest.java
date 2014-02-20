/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 8:30 PM
 */

// Draws a sprite at coordinate (VX, VY) that has a width of 8 pixels and a height of N pixels.
// Each row of 8 pixels is read as bit-coded (with the most significant bit of each byte displayed on the left)
// starting from memory location I; I value doesn't change after the execution of this instruction.
// As described above, VF is set to 1 if any screen pixels are flipped from set to unset when the sprite is drawn,
// and to 0 if that doesn't happen.

package unittests.OpCodes;

import lib.MachineState;
import lib.Memory;
import lib.OpCodes.OpCodeDXYN;
import lib.PixelBuffer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class OpCodeDXYNTest {

    private PixelBuffer pixelBuffer;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        pixelBuffer = mock(PixelBuffer.class);
        machineState = new MachineState(new Memory(), pixelBuffer);
    }

    @Test
    public void execute_x0y1N1I0_0() throws Exception {
        setupParameterRegisters();
        OpCodeDXYN opCode = new OpCodeDXYN(0xD011);
        opCode.execute(machineState);
        assertVF(0);
    }

    @Test
    public void execute_x0y1N1I0_bitsArePixels() throws Exception {
        setupParameterRegisters();
        machineState.memory.set(0, 0b10101001);
        OpCodeDXYN opCode = new OpCodeDXYN(0xD011);
        when(pixelBuffer.isPixelSet(anyInt(), anyInt())).thenReturn(false);
        opCode.execute(machineState);
        verify(pixelBuffer).setPixel(10, 20);
        verify(pixelBuffer).setPixel(12, 20);
        verify(pixelBuffer).setPixel(14, 20);
        verify(pixelBuffer).setPixel(17, 20);
        assertVF(1);
    }

    @Test
    public void execute_x0y1N2I0_bitsArePixels() throws Exception {
        setupParameterRegisters();
        machineState.memory.set(0, 0b10101001);
        machineState.memory.set(1, 0b11110000);
        OpCodeDXYN opCode = new OpCodeDXYN(0xD012);
        when(pixelBuffer.isPixelSet(anyInt(), anyInt())).thenReturn(false);

        opCode.execute(machineState);
        verify(pixelBuffer).setPixel(10, 20);
        verify(pixelBuffer).setPixel(12, 20);
        verify(pixelBuffer).setPixel(14, 20);
        verify(pixelBuffer).setPixel(17, 20);
        verify(pixelBuffer).setPixel(10, 21);
        verify(pixelBuffer).setPixel(11, 21);
        verify(pixelBuffer).setPixel(12, 21);
        verify(pixelBuffer).setPixel(13, 21);
        assertVF(1);
    }

    @Test
    public void execute_nothingToDraw() throws Exception {
        setupParameterRegisters();
        machineState.V[15] = 1;
        machineState.memory.set(0, 0b10000000);
        OpCodeDXYN opCode = new OpCodeDXYN(0xD011);
        when(pixelBuffer.isPixelSet(10, 20)).thenReturn(true);
        opCode.execute(machineState);
        verify(pixelBuffer, never()).setPixel(anyInt(), anyInt());
        assertVF(0);
    }

    private void setupParameterRegisters() {
        machineState.V[0] = 10;
        machineState.V[1] = 20;
        machineState.I = 0;
    }

    private void assertVF(int value) {
        assertThat(machineState.V[15], is(value));
    }
}
