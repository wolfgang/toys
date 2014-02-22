/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:38 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode8XY3;
import org.junit.Test;

public class OpCode8XY3Test extends OpCodeTest
{
    @Test
    public void execute_sets_VX_to_VX_xor_VY() throws Exception {
        opCode = new OpCode8XY3();
        givenVX(5, 0x64);
        givenVX(14, 0x76);
        executeOpCode(0x85E3);
        assertVX(5, 0x64 ^ 0x76);
        assertVX(14, 0x76);
    }
}
