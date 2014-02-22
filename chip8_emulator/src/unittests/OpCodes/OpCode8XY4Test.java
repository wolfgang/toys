/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 11:59 AM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode8XY4;
import org.junit.Before;
import org.junit.Test;

public class OpCode8XY4Test extends OpCodeTest {
    @Before
    public void createOpCode() {
        opCode = new OpCode8XY4();
    }

    @Test
    public void adds_VY_to_VX_sets_VF_to_1_becauseThereIsACarry() throws Exception {
        givenVX(5, 0xF000);
        givenVX(6, 0xF100);
        givenVF(0);

        executeOpCode(0x8564);

        assertVX(5, 0x1E100);
        assertVX(6, 0xF100);
        assertVF(1);
    }

    @Test
    public void adds_VY_to_VX_sets_VF_to_0_becauseThereIsNoCarry() throws Exception {
        givenVX(5, 0x1000);
        givenVX(6, 0x1000);
        givenVF(1);

        executeOpCode(0x8564);

        assertVX(5, 0x2000);
        assertVX(6, 0x1000);
        assertVF(0);
    }
}
