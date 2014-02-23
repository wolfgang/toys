/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 4:26 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeANNN;
import org.junit.Test;

public class OpCodeANNNTest extends OpCodeTest {
    //Sets I to the address NNN.
    @Test
    public void sets_I_to_NNN() throws Exception {
        opCode = new OpCodeANNN();
        givenI(0x1234);
        executeOpCode(0xA567);
        assertI(0x567);
    }
}
