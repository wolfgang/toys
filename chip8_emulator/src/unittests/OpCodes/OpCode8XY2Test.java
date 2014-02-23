/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:35 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode8XY2;
import org.junit.Test;

public class OpCode8XY2Test extends OpCodeTest {
    @Test
    public void execute_sets_VX_to_VX_and_VY() throws Exception {
        opCode = new OpCode8XY2();
        givenV(3, 0x12);
        givenV(12, 0x87);
        executeOpCode(0x83C2);
        assertV(3, 0x12 & 0x87);
        assertV(12, 0x87);
    }
}
