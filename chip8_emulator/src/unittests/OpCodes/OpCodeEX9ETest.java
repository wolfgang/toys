/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 8:25 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeEX9E;
import org.junit.Before;
import org.junit.Test;

public class OpCodeEX9ETest extends OpCodeTest{
    //Skips the next instruction if the key stored in VX is pressed
    @Before
    public void createOpCode() {
        opCode = new OpCodeEX9E();
    }

    @Test
    public void key_0_is_pressed() throws Exception {
        givenVX(5, 0);
        machineState.keyboard = 0x1;
        executeOpCode(0xE59E);
        assertPC(0x204);
    }

    @Test
    public void key_0_is_not_pressed() throws Exception {
        givenVX(5, 0);
        machineState.keyboard = 0x1110;
        executeOpCode(0xE59E);
        assertPC(0x200);
    }

    @Test
    public void key_9_is_pressed() throws Exception {
        givenVX(5, 9);
        machineState.keyboard = 0b0110111011001111;
        executeOpCode(0xE59E);
        assertPC(0x204);
    }

    @Test
    public void key_9_is_not_pressed() throws Exception {
        givenVX(5, 9);
        machineState.keyboard = 0b0110110010001111;
        executeOpCode(0xE59E);
        assertPC(0x200);
    }

    @Test
    public void key_15_is_pressed() throws Exception {
        givenVX(5, 15);
        machineState.keyboard = 0b1110110011001111;
        executeOpCode(0xE59E);
        assertPC(0x204);
    }

    @Test
    public void key_15_is_not_pressed() throws Exception {
        givenVX(5, 15);
        machineState.keyboard = 0b0110110011001110;
        executeOpCode(0xE59E);
        assertPC(0x200);
    }



}
