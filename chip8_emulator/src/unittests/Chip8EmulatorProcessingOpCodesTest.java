/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 4:46 PM
 */

package unittests;

import lib.Chip8Emulator;
import lib.MachineState;
import lib.OpCodeDecoder;
import lib.OpCodes.OpCode;
import lib.PixelBuffer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class Chip8EmulatorProcessingOpCodesTest {

    private OpCodeDecoder opCodeDecoder;
    private OpCode opCode;
    private Chip8Emulator emulator;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        opCodeDecoder = mock(OpCodeDecoder.class);
        opCode = mock(OpCode.class);
        machineState = new MachineState(null, mock(PixelBuffer.class));
        emulator = new Chip8Emulator(machineState, opCodeDecoder);
    }

    @Test
    public void tick_processNextOpcode_AdvancePC() throws Exception {
        when(opCodeDecoder.getNext(0x200)).thenReturn(opCode);
        emulator.tick();
        verify(opCode).execute(machineState);
        assertThat(machineState.pc, is(0x202));
    }

    @Test
    public void tick_dontAdvancePCIfOpCodeChangedIt() throws Exception {
        when(opCodeDecoder.getNext(0x200)).thenReturn(new PCChangingOpCode());
        emulator.tick();
        assertThat(machineState.pc, is(0x300));
    }

    private class PCChangingOpCode implements OpCode {
        @Override
        public void execute(MachineState incomingMachineState) {
            incomingMachineState.pc = 0x300;
        }

        @Override
        public void execute(MachineState machineState, int myCode) {

        }
    }
}
