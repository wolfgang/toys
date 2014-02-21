/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 11:06 AM
 */

package unittests;

import lib.InvalidOpCodeId;
import lib.OpCodeFactory;
import lib.OpCodeIds;
import lib.OpCodes.OpCode;
import lib.OpCodes.OpCode00E0;
import lib.OpCodes.OpCode1NNN;
import lib.OpCodes.OpCodeDXYN;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class OpCodeFactoryTest {

    private OpCodeFactory opCodeFactory;

    @Before
    public void setUp() throws Exception {
        opCodeFactory = new OpCodeFactory();
    }

    @Test
    public void create_00E0() throws Exception {
        OpCode opCode = opCodeFactory.create(OpCodeIds.OP_00E0);
        assertThat(opCode, instanceOf(OpCode00E0.class));
    }

    @Test
    public void create_DXYN() throws Exception {
        OpCode opCode = opCodeFactory.create(OpCodeIds.OP_DXYN);
        assertThat(opCode, instanceOf(OpCodeDXYN.class));
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
