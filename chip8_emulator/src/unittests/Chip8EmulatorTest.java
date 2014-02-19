/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 4:46 PM
 */

package unittests;

import lib.*;
import lib.OpCodes.OpCode;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class Chip8EmulatorTest {

    private OldDisplay oldDisplay;
    private OpCodeDecoder opCodeDecoder;
    private OpCode opCode;
    private Chip8Emulator emulator;
    private InOrder order;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        opCodeDecoder = mock(OpCodeDecoder.class);
        opCode = mock(OpCode.class);
        oldDisplay = mock(OldDisplay.class);
        machineState = new MachineState(null, oldDisplay);
        emulator = new Chip8Emulator(machineState, opCodeDecoder);
        order = inOrder(opCode, oldDisplay);
    }

    @Test
    public void tick_processNextOpcode_AdvancePC_DrawScreen() throws Exception {
        when(opCodeDecoder.getNext(0x200)).thenReturn(opCode);
        emulator.tick();
        order.verify(opCode).execute(machineState);
        order.verify(oldDisplay).draw();
        assertThat(machineState.pc, is(0x202));
    }

    @Test
    public void tick_dontAdvancePCIfOpCodeChangedIt() throws Exception {
        when(opCodeDecoder.getNext(0x200)).thenReturn(new PCChangingOpCode());
        emulator.tick();
        order.verify(oldDisplay).draw();
        assertThat(machineState.pc, is(0x300));
    }

    private class PCChangingOpCode implements OpCode {
        @Override
        public void execute(MachineState incomingMachineState) {
            incomingMachineState.pc = 0x300;
        }
    }
}
