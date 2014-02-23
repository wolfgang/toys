/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:13 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeFX1E;
import org.junit.Test;

public class OpCodeFX1ETest extends OpCodeTest {
    @Test
    public void adds_VX_to_I() throws Exception {
        opCode = new OpCodeFX1E();
        givenV(1, 0x20);
        givenI(0x50);
        executeOpCode(0xF11E);
        assertI(0x70);
    }

}
