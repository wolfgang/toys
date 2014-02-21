/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:37 PM
 */

package unittests;

import lib.*;
import lib.OpCodes.OpCode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Chip8EmulatorTickWithPCChangingOpCodeTest {
    private MachineState machineState;
    private OpCodeRegistry opCodeRegistry;
    private Chip8Emulator emulator;

    @Before
    public void setUp() throws Exception {
        machineState = new MachineState(new Memory(), mock(PixelBuffer.class));
        opCodeRegistry = mock(OpCodeRegistry.class);
        emulator = new Chip8Emulator(machineState, new OpCodeExecutor(machineState, opCodeRegistry));
    }

    @Test
    public void dontAdvancePCIfOpCodeChangedIt() throws Exception {
        when(opCodeRegistry.getOpCode(anyInt())).thenReturn(new PCChangingOpCode());
        emulator.tick();
        assertThat(machineState.pc, is(0x300));
    }

    private class PCChangingOpCode implements OpCode {
        @Override
        public void execute(MachineState incomingMachineState, int myCode) {
            incomingMachineState.pc = 0x300;
        }
    }

}
