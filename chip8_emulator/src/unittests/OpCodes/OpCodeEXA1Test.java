/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 8:40 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeEXA1;
import org.junit.Before;
import org.junit.Test;

public class OpCodeEXA1Test extends OpCodeTest {
    //Skips the next instruction if the key stored in VX is not pressed
    @Before
    public void createOpCode() {
        opCode = new OpCodeEXA1();
    }

    @Test
    public void key_10_is_not_pressed() throws Exception {
        givenVX(5, 10);
        machineState.keyboard = 0x01;
        executeOpCode(0xE5A1);
        assertPC(0x204);
    }

    @Test
    public void key_10_is_pressed() throws Exception {
        givenVX(5, 10);
        machineState.keyboard = 0b0000010000100000;
        executeOpCode(0xE5A1);
        assertPC(0x200);
    }
}
