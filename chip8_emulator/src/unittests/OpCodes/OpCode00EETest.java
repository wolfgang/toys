/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 4:43 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode00EE;
import org.junit.Test;

public class OpCode00EETest extends OpCodeTest {

    @Test
    public void execute() throws Exception {
        opCode = new OpCode00EE();
        machineState.pushOntoStack(0x300);
        executeOpCode(0);
        assertPC(0x300);
    }
}
