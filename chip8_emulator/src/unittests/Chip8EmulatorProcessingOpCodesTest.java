/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 4:46 PM
 */

package unittests;

import lib.*;
import lib.OpCodes.OpCode;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class Chip8EmulatorProcessingOpCodesTest {

    private OpCodeExecutor opCodeExecutor;
    private Chip8Emulator emulator;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        opCodeExecutor = mock(OpCodeExecutor.class);
        machineState = new MachineState(null, mock(PixelBuffer.class));
        emulator = new Chip8Emulator(machineState, opCodeExecutor);
    }

    @Test
    public void tick_processNextOpcode_AdvancePC() throws Exception {
        emulator.tick();
        verify(opCodeExecutor).executeNext();
        assertThat(machineState.pc, is(0x202));
    }

    @Test
    @Ignore
    public void tick_dontAdvancePCIfOpCodeChangedIt() throws Exception {
        verify(opCodeExecutor).executeNext();
        emulator.tick();
        assertThat(machineState.pc, is(0x300));
    }


    @SuppressWarnings("UnusedDeclaration")
    private class PCChangingOpCode implements OpCode {
        @Override
        public void execute(MachineState incomingMachineState, int myCode) {
            incomingMachineState.pc = 0x300;

        }
    }
}
