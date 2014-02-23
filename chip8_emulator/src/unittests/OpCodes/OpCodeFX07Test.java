/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 12:45 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeFX07;
import org.junit.Test;

public class OpCodeFX07Test extends OpCodeTest {
    @Test
    public void sets_VX_to_delay_timer_value() throws Exception {
        opCode = new OpCodeFX07();
        givenV(10, 0x50);
        givenDelayTimer(0x20);
        executeOpCode(0xFA07);
        assertVX(10, 0x20);
    }
}
