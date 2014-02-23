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
        executeOpCode(0xF029);
        assertI(0x0);
    }

    @Test
    public void sets_I_to_location_of_sprite_for_1() throws Exception {
        executeOpCode(0xF129);
        assertI(5);
    }

    @Test
    public void sets_I_to_location_of_sprite_for_A() throws Exception {
        executeOpCode(0xFA29);
        assertI(50);
    }

    @Test
    public void sets_I_to_location_of_sprite_for_F() throws Exception {
        executeOpCode(0xFF29);
        assertI(75);
    }


}
