/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 4:32 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeBNNN;
import org.junit.Test;

public class OpCodeBNNNTest extends OpCodeTest {
    //Jumps to the address NNN plus V0.
    @Test
    public void sets_pc_to_NNN_plus_V0() throws Exception {
        opCode = new OpCodeBNNN();
        givenV(0, 0x20);
        givenPC(0x400);
        executeOpCode(0xB250);
        assertPC(0x270);
    }
}
