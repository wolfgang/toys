/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:13 PM
 */

package unittests;

import lib.*;
import lib.OpCodes.OpCode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class OpCodeExecutorTest {
    private Memory memory;
    private OpCodeRegistry opCodeRegistry;
    private OpCodeExecutor opCodeExecutor;
    private OpCode opCode1020;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        memory = mock(Memory.class);
        machineState = new MachineState();
        opCodeRegistry = mock(OpCodeRegistry.class);
        opCodeExecutor = new OpCodeExecutor(opCodeRegistry, memory);
        opCode1020 = mock(OpCode.class, "OpCode 1020");
    }

    @Test
    public void executeNext() throws Exception {
        machineState.pc = 0x200;
        memoryAt(0x200, 0x10);
        memoryAt(0x201, 0x20);
        opCodeFor(0x1020, opCode1020);
        opCodeExecutor.executeNext(machineState);
        verify(opCode1020).execute(machineState, 0x1020);
        assertThat(machineState.pc, is(0x200));
    }

    private void opCodeFor(int code, OpCode opCode) throws InvalidOpCode {
        when(opCodeRegistry.getOpCode(code)).thenReturn(opCode);
    }

    private void memoryAt(int address, int value) {
        when(memory.get(address)).thenReturn((byte) value);
    }
}
