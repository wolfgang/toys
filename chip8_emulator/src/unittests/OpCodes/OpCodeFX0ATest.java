/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 1:07 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeFX0A;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCodeFX0ATest extends OpCodeTest {
    //A key press is awaited, and then stored in VX.
    @Test
    public void noKeyPressed_setWaitInMachineState() throws Exception {
        opCode = new OpCodeFX0A();
        machineState.wait = false;
        machineState.keyboard = 0;
        executeOpCode(0xF50A);
        assertThat(machineState.wait, is(true));
    }

    @Test
    public void key16IsPressed_setWaitToFalse_storeIndexInVX() throws Exception {
        opCode = new OpCodeFX0A();
        machineState.wait = true;
        machineState.keyboard = 0x8000;
        executeOpCode(0xF50A);
        assertThat(machineState.wait, is(false));
        assertVX(5, 15);
    }

    @Test
    public void key10IsPressed_setWaitToFalse_storeIndexInVX() throws Exception {
        opCode = new OpCodeFX0A();
        machineState.wait = true;
        machineState.keyboard = 0b0000000010000000;
        executeOpCode(0xF50A);
        assertThat(machineState.wait, is(false));
        assertVX(5, 7);
    }

}
