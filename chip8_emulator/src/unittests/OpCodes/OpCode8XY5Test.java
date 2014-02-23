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
    public void createOpCode() {
        opCode = new OpCode8XY5();
    }

    @Test
    public void subtract_VY_from_VX_set_VF_to_0_becauseThereIsABorrow() throws Exception {
        givenV(5, 0x10);
        givenV(12, 0x20);
        givenVF(1);

        executeOpCode(0x85C5);

        assertV(5, 0x10 - 0x20);
        assertV(12, 0x20);
        assertVF(0);
    }

    @Test
    public void subtract_VY_from_VX_set_VF_to_1_becauseThereIsNoBorrow() throws Exception {
        givenV(5, 0x30);
        givenV(12, 0x10);
        givenVF(0);

        executeOpCode(0x85C5);

        assertV(5, 0x30 - 0x10);
        assertV(12, 0x10);
        assertVF(1);
    }
}
