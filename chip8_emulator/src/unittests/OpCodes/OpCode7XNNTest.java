/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:49 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode7XNN;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCode7XNNTest extends OpCodeTest {
    @Test
    public void execute_add_NN_to_VX() throws Exception {
        opCode = new OpCode7XNN();
        machineState.V[5] = 0x40;
        opCode.execute(machineState, 0x7520);
        assertThat(machineState.V[5], is(0x60));

    }
}
