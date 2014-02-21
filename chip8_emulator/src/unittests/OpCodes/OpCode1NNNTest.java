/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:55 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode1NNN;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OpCode1NNNTest extends OpCodeTest {
    @Test
    public void execute_changePCToNNN() throws Exception {
        opCode = new OpCode1NNN();
        opCode.execute(machineState, 0x1400);
        assertThat(machineState.pc, is(0x400));
    }
}
