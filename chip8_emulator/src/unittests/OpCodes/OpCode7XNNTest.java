/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:49 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode7XNN;
import org.junit.Test;

public class OpCode7XNNTest extends OpCodeTest {
    @Test
    public void execute_add_NN_to_VX() throws Exception {
        opCode = new OpCode7XNN();
        machineState.V[5] = 0x40;
        executeOpCode(0x7520);
        assertVX(5, 0x60);
    }
}
