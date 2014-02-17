/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:20 PM
 */

package unittests;

import lib.Memory;
import lib.OpCode;
import lib.OpCodeDecoder;
import lib.OpCodeFactory;
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
    private OpCode opCode3040;

    @Before
    public void setUp() throws Exception {
        memory = mock(Memory.class);
        opCodeFactory = mock(OpCodeFactory.class);
        opCodeDecoder = new OpCodeDecoder(memory, opCodeFactory);
        opCode1020 = mock(OpCode.class, "OpCode 1020");
        opCode3040 = mock(OpCode.class, "OpCode 3040");
    }

    @Test
    public void getNext_startAt0x200() throws Exception {
        memoryAt(0x200, 0x10);
        memoryAt(0x201, 0x20);
        opCodeFor(0x1020, opCode1020);
        verifyGetNext(opCode1020);
    }

    @Test
    public void getNext_advanceByTwo() throws Exception {
        memoryAt(0x200, 0x10);
        memoryAt(0x201, 0x20);
        memoryAt(0x202, 0x30);
        memoryAt(0x203, 0x40);
        opCodeFor(0x1020, opCode1020);
        opCodeFor(0x3040, opCode3040);
        verifyGetNext(opCode1020);
        verifyGetNext(opCode3040);
    }

    private void opCodeFor(int code, OpCode opCode) {
        when(opCodeFactory.getOpCode(code)).thenReturn(opCode);
    }

    private void memoryAt(int address, int value) {
        when(memory.get(address)).thenReturn(value);
    }

    private void verifyGetNext(OpCode opCode) {
        assertThat(opCodeDecoder.getNext(), is(opCode));
    }
}
