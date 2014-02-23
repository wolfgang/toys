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
        givenV(5, 0xEF);
        givenV(6, 0x1F);
        givenVF(0);

        executeOpCode(0x8564);

        assertV(5, 0xEF + 0x1F);
        assertV(6, 0x1F);
        assertVF(1);
    }

    @Test
    public void adds_VY_to_VX_sets_VF_to_0_becauseThereIsNoCarry() throws Exception {
        givenV(5, 0x10);
        givenV(6, 0x10);
        givenVF(1);

        executeOpCode(0x8564);

        assertV(5, 0x20);
        assertV(6, 0x10);
        assertVF(0);
    }
}
