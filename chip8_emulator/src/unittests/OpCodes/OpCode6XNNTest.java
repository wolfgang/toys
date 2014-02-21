/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:31 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode6XNN;
import org.junit.Test;

public class OpCode6XNNTest extends OpCodeTest {
    @Test
    public void execute() throws Exception {
        opCode = new OpCode6XNN();
        machineState.V[5] = 0x10;
        executeOpCode(0x6520);
        assertVX(5, 0x20);
    }
}