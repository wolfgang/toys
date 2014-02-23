/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:03 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode8XY0;
import org.junit.Test;

public class OpCode8XY0Test extends OpCodeTest {
    @Test
    public void execute_sets_VX_to_VY() throws Exception {
        opCode = new OpCode8XY0();
        givenV(10, 10);
        givenV(12, 20);
        executeOpCode(0x8AC0);
        assertVX(10, 20);
        assertVX(12, 20);
    }
}
