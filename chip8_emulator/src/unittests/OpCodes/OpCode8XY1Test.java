/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:14 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode8XY1;
import org.junit.Test;

public class OpCode8XY1Test extends OpCodeTest {
    @Test
    public void execute_sets_VX_to_VX_or_VY() throws Exception {
        opCode = new OpCode8XY1();
        givenV(7, 0x20);
        givenV(1, 0x56);
        executeOpCode(0x8711);
        assertVX(7, 0x20 | 0x56);
        assertVX(1, 0x56);
    }
}
