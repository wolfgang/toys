/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:07 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeFX18;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCodeFX18Test extends OpCodeTest {
    @Test
    public void sets_sound_timer_to_VX() throws Exception {
        opCode = new OpCodeFX18();
        machineState.sound_timer = 0x30;
        givenVX(12, 0x81);
        executeOpCode(0xFC18);
        assertThat(machineState.sound_timer, is(0x81));
    }
}
