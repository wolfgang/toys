/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 4:46 PM
 */

package unittests;

import lib.Chip8Emulator;
import lib.Display;
import lib.MachineState;
import lib.OpCodeExecutor;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class Chip8EmulatorProcessingOpCodesTest {
    private OpCodeExecutor opCodeExecutor;
    private Chip8Emulator emulator;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        opCodeExecutor = mock(OpCodeExecutor.class);
        machineState = new MachineState();
        emulator = new Chip8Emulator(machineState, opCodeExecutor, mock(Display.class));
    }

    @Test
    public void tick_processNextOpcode_AdvancePC() throws Exception {
        emulator.tick();
        verify(opCodeExecutor).executeNext(machineState);
        assertThat(machineState.pc, is(0x202));
    }

    @Test
    public void tick_dontAdvancePCIfMachineStateWaitIsTrue() throws Exception {
        machineState.wait = true;
        emulator.tick();
        assertThat(machineState.pc, is(0x200));
    }

}
