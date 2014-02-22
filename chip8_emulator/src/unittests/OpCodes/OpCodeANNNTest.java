/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 4:26 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeANNN;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCodeANNNTest extends OpCodeTest {
    //Sets I to the address NNN.
    @Test
    public void sets_I_to_NNN() throws Exception {
        opCode = new OpCodeANNN();
        machineState.I = 0x1234;
        executeOpCode(0xA567);
        assertThat(machineState.I, is(0x567));
    }
}
