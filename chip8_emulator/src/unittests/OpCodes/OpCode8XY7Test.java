/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 2:14 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode8XY7;
import org.junit.Before;
import org.junit.Test;

// Sets VX to VY minus VX. VF is set to 0 when there's a borrow, and 1 when there isn't.
public class OpCode8XY7Test extends OpCodeTest {
    @Before
    public void createOpCode() {
        opCode = new OpCode8XY7();
    }

    @Test
    public void execute_with_borrow_set_to_VF_0() throws Exception {
        givenV(5, 0x50);
        givenV(10, 0x10);
        givenVF(1);
        executeOpCode(0x85A7);
        assertVX(5, 0x10 - 0x50);
        assertVX(10, 0x10);
        assertVF(0);
    }

    @Test
    public void execute_with_no_borrow_set_to_VF_1() throws Exception {
        givenV(5, 0x50);
        givenV(10, 0x100);
        givenVF(0);
        executeOpCode(0x85A7);
        assertVX(5, 0x100 - 0x50);
        assertVX(10, 0x100);
        assertVF(1);
    }

}
