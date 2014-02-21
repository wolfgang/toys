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

import lib.Display;
import lib.MachineState;
import lib.Memory;
import lib.OpCodes.OpCodeDXYN;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class OpCodeDXYNTest {

    private Display display;
    private MachineState machineState;
    private Memory memory;
    private OpCodeDXYN opCode;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        memory = new Memory();
        machineState = new MachineState(new Memory(), display);
        opCode = new OpCodeDXYN(display, memory);
    }

    @Test
    public void execute_x0y1N1I0_0() throws Exception {
        setupParameterRegisters();
        opCode.execute(machineState, 0xD011);
        assertVF(0);
    }

    @Test
    public void execute_x0y1N1I0_bitsArePixels() throws Exception {
        setupParameterRegisters();
        memory.set(0, 0b10101001);
        when(display.isPixelSet(anyInt(), anyInt())).thenReturn(false);
        opCode.execute(machineState, 0xD011);
        verify(display).setPixel(10, 20);
        verify(display).setPixel(12, 20);
        verify(display).setPixel(14, 20);
        verify(display).setPixel(17, 20);
        assertVF(1);
    }

    @Test
    public void execute_x0y1N2I0_bitsArePixels() throws Exception {
        setupParameterRegisters();
        memory.set(0, 0b10101001);
        memory.set(1, 0b11110000);
        when(display.isPixelSet(anyInt(), anyInt())).thenReturn(false);

        opCode.execute(machineState, 0xD012);
        verify(display).setPixel(10, 20);
        verify(display).setPixel(12, 20);
        verify(display).setPixel(14, 20);
        verify(display).setPixel(17, 20);
        verify(display).setPixel(10, 21);
        verify(display).setPixel(11, 21);
        verify(display).setPixel(12, 21);
        verify(display).setPixel(13, 21);
        assertVF(1);
    }

    @Test
    public void execute_nothingToDraw() throws Exception {
        setupParameterRegisters();
        machineState.V[15] = 1;
        memory.set(0, 0b10000000);
        when(display.isPixelSet(10, 20)).thenReturn(true);
        opCode.execute(machineState, 0xD011);
        verify(display, never()).setPixel(anyInt(), anyInt());
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
