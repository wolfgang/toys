/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 1:51 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode8XY5;
import org.junit.Before;
import org.junit.Test;

public class OpCode8XY5Test extends OpCodeTest {
    @Before
    public void createOpCode()
    {
        opCode = new OpCode8XY5();
    }
    @Test
    public void subtract_VY_from_VX_set_VF_to_1_becauseThereIsABorrow() throws Exception {
        givenVX(5, 0x10);
        givenVX(12, 0x20);
        givenVF(0);

        executeOpCode(0x85C5);

        assertVX(5, 0x10 - 0x20);
        assertVX(12, 0x20);
        assertVF(1);
    }

    @Test
    public void subtract_VY_from_VX_set_VF_to_0_becauseThereIsNoBorrow() throws Exception {
        givenVX(5, 0x30);
        givenVX(12, 0x10);
        givenVF(1);

        executeOpCode(0x85C5);

        assertVX(5, 0x30 - 0x10);
        assertVX(12, 0x10);
        assertVF(0);
    }
}
