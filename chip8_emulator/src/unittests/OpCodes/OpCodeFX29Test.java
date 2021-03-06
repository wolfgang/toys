/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:23 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeFX29;
import org.junit.Before;
import org.junit.Test;

public class OpCodeFX29Test extends OpCodeTest {
    @Before
    public void setUp() {
        opCode = new OpCodeFX29();
        givenI(0x100);
    }

    @Test
    public void sets_I_to_location_of_sprite_for_0() throws Exception {
        givenV(0, 0);
        executeOpCode(0xF029);
        assertI(0x0);
    }

    @Test
    public void sets_I_to_location_of_sprite_for_1() throws Exception {
        givenV(1, 1);
        executeOpCode(0xF129);
        assertI(5);
    }

    @Test
    public void sets_I_to_location_of_sprite_for_A() throws Exception {
        givenV(10, 5);
        executeOpCode(0xFA29);
        assertI(25);
    }

    @Test
    public void sets_I_to_location_of_sprite_for_F() throws Exception {
        givenV(15, 10);
        executeOpCode(0xFF29);
        assertI(50);
    }


}
