/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:20 PM
 */

package unittests;

import lib.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OpCodeDecoderTest {

    private Memory memory;
    private OpCodeFactory opCodeFactory;
    private OpCodeDecoder opCodeDecoder;
    private OpCode opCode1020;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        memory = mock(Memory.class);
        opCodeFactory = mock(OpCodeFactory.class);
        machineState = new MachineState();
        opCodeDecoder = new OpCodeDecoder(memory, opCodeFactory);
        opCode1020 = mock(OpCode.class, "OpCode 1020");
    }

    @Test
    public void getNext_getFromPCInMachineState() throws Exception {
        machineState.pc = 0x200;
        memoryAt(0x200, 0x10);
        memoryAt(0x201, 0x20);
        opCodeFor(0x1020, opCode1020);
        verifyGetNext(opCode1020);
        assertThat(machineState.pc, is(0x200));
    }

    private void opCodeFor(int code, OpCode opCode) throws InvalidOpCode {
        when(opCodeFactory.getOpCode(code)).thenReturn(opCode);
    }

    private void memoryAt(int address, int value) {
        when(memory.get(address)).thenReturn(value);
    }

    private void verifyGetNext(OpCode opCode) throws InvalidOpCode {
        assertThat(opCodeDecoder.getNext(0x200), is(opCode));
    }
}
