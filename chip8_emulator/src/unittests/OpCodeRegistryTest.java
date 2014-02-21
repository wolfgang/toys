/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 6:03 PM
 */

package unittests;

import lib.InvalidOpCode;
import lib.OpCodeRegistry;
import lib.OpCodes.OpCode;
import lib.OpCodes.OpCode00E0;
import lib.OpCodes.OpCode1NNN;
import lib.OpCodes.OpCodeDXYN;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class OpCodeRegistryTest {

    private OpCodeRegistry opCodeRegistry;

    @Before
    public void setUp() throws Exception {
        opCodeRegistry = new OpCodeRegistry();
    }

    @Test
    public void getOpCode_1NNN_600() throws Exception {
        OpCode opCode = opCodeRegistry.getOpCode(0x1600);
        assertThat(opCode, instanceOf(OpCode1NNN.class));
    }

    @Test
    public void getOpCode_1NNN_700() throws Exception {
        OpCode opCode = opCodeRegistry.getOpCode(0x1700);
        assertThat(opCode, instanceOf(OpCode1NNN.class));
    }

    @Test
    public void getOpCode_00E0() throws Exception {
        OpCode opCode = opCodeRegistry.getOpCode(0x00E0);
        assertThat(opCode, instanceOf(OpCode00E0.class));

    }

    @Test
    public void getOpCode_DXYN() throws Exception {
        OpCode opCode = opCodeRegistry.getOpCode(0xD123);
        assertThat(opCode, instanceOf(OpCodeDXYN.class));

    }

    @Test(expected = InvalidOpCode.class)
    public void getOpCode_invalidCode_throwInvalidOpCode() throws Exception {
        opCodeRegistry.getOpCode(0x0000);
    }
}
