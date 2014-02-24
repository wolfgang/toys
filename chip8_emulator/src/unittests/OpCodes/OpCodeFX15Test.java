/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:02 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeFX15;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCodeFX15Test extends OpCodeTest {
    @Test
    public void sets_delay_timer_to_VX() throws Exception {
        opCode = new OpCodeFX15();
        machineState.delay_timer = 0x20;
        givenV(11, 0x40);
        executeOpCode(0xFB15);
        assertThat(machineState.delay_timer, is((byte)0x40));
    }
}
