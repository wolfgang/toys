/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:31 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode6XNN;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCode6XNNTest extends OpCodeTest {
    @Test
    public void execute() throws Exception {
        opCode = new OpCode6XNN();
        machineState.V[5] = 0x10;
        opCode.execute(machineState, 0x6520);
        assertThat(machineState.V[5], is(0x20));
    }
}
