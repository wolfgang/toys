/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 4:46 PM
 */

package unittests;

import lib.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class Chip8EmulatorTest {

    private Screen screen;
    private OpCodeDecoder opCodeDecoder;
    private OpCode opCode;
    private Chip8Emulator emulator;
    private InOrder order;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        screen = mock(Screen.class);
        opCodeDecoder = mock(OpCodeDecoder.class);
        opCode = mock(OpCode.class);
        machineState = new MachineState();
        emulator = new Chip8Emulator(machineState, screen, opCodeDecoder);
        order = inOrder(opCode, screen);
    }

    @Test
    public void tick_processNextOpcode_AdvancePC_DrawScreen() throws Exception {
        when(opCodeDecoder.getNext()).thenReturn(opCode);
        emulator.tick();
        order.verify(opCode).execute();
        order.verify(screen).draw();
        assertThat(machineState.pc, is(0x202));
    }

    @Test
    public void tick_dontChangePCIfOpCodeChangedIt() throws Exception {
        when(opCodeDecoder.getNext()).thenReturn(new PCChangingOpCode());
        emulator.tick();
        order.verify(screen).draw();
        assertThat(machineState.pc, is(0x300));
    }

    private class PCChangingOpCode implements OpCode {
        @Override
        public void execute() {
            machineState.pc = 0x300;
        }
    }
}
