/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 6:03 PM
 */

package unittests;

import lib.InvalidOpCode;
import lib.OpCodeFactory;
import lib.OpCodes.OpCode;
import lib.OpCodes.OpCode00E0;
import lib.OpCodes.OpCode1NNN;
import lib.OpCodes.OpCodeDXYN;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OpCodeFactoryTest {

    private OpCodeFactory opCodeFactory;

    @Before
    public void setUp() throws Exception {
        opCodeFactory = new OpCodeFactory();
    }

    @Test
    public void getOpCode_1NNN_600() throws Exception {
        OpCode opCode = opCodeFactory.getOpCode(0x1600);
        assertIs1NNN(opCode, 0x600);
    }

    @Test
    public void getOpCode_1NNN_700() throws Exception {
        OpCode opCode = opCodeFactory.getOpCode(0x1700);
        assertIs1NNN(opCode, 0x700);
    }

    @Test
    public void getOpCode_00E0() throws Exception {
        OpCode opCode = opCodeFactory.getOpCode(0x00E0);
        assertIs00E0(opCode);
    }

    @Test
    public void getOpCode_DXYN() throws Exception {
        OpCode opCode = opCodeFactory.getOpCode(0xD123);
        assertOpCode(opCode, OpCodeDXYN.class, "1 2 3");
    }

    @Test(expected = InvalidOpCode.class)
    public void getOpCode_invalidCode_throwInvalidOpCode() throws Exception {
        opCodeFactory.getOpCode(0x0000);
    }

    private void assertIs1NNN(OpCode opCode, int destination) {
        assertOpCode(opCode, OpCode1NNN.class, String.valueOf(destination));
    }

    private void assertIs00E0(OpCode opCode) {
        assertThat(opCode, instanceOf(OpCode00E0.class));
    }

    private void assertOpCode(OpCode opCode, Class expectedClass, String expectedStringValue)
    {
        assertThat(opCode, instanceOf(expectedClass));
        assertThat(opCode.toString(), is(expectedStringValue));
    }
}
