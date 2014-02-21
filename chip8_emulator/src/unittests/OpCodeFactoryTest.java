/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 11:06 AM
 */

package unittests;

import lib.*;
import lib.OpCodes.OpCode;
import lib.OpCodes.OpCode00E0;
import lib.OpCodes.OpCode1NNN;
import lib.OpCodes.OpCodeDXYN;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class OpCodeFactoryTest {

    private OpCodeFactory opCodeFactory;
    private PixelBuffer pixelBuffer;
    private Memory memory;

    @Before
    public void setUp() throws Exception {
        pixelBuffer = mock(PixelBuffer.class);
        memory = mock(Memory.class);
        opCodeFactory = new OpCodeFactory(pixelBuffer, memory);
    }

    @Test
    public void create_00E0() throws Exception {
        OpCode opCode = opCodeFactory.create(OpCodeIds.OP_00E0);
        assertThat(opCode, instanceOf(OpCode00E0.class));
        OpCode00E0 opCode00E0 = (OpCode00E0)opCode;
        assertThat(opCode00E0.getPixelBuffer(), is(pixelBuffer));
    }

    @Test
    public void create_DXYN() throws Exception {
        OpCode opCode = opCodeFactory.create(OpCodeIds.OP_DXYN);
        assertThat(opCode, instanceOf(OpCodeDXYN.class));
        OpCodeDXYN opCodeDXYN = (OpCodeDXYN)opCode;
        assertThat(opCodeDXYN.getPixelBuffer(), is(pixelBuffer));
        assertThat(opCodeDXYN.getMemory(), is(memory));
    }

    @Test
    public void create_1NNN() throws Exception {
        OpCode opCode = opCodeFactory.create(OpCodeIds.OP_1NNN);
        assertThat(opCode, instanceOf(OpCode1NNN.class));
    }

    @Test(expected = InvalidOpCodeId.class)
    public void invalidOpCodeIdThrowsException() throws Exception {
        opCodeFactory.create(12345678);
    }
}
