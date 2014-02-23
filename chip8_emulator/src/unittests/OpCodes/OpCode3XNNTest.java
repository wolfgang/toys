/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 6:11 PM
 */

package unittests.OpCodes;

import lib.MachineState;
import lib.OpCodes.OpCode3XNN;
import org.junit.Before;
import org.junit.Test;

public class OpCode3XNNTest extends OpCodeTest {

    @Before
    public void setUp() throws Exception {
        opCode = new OpCode3XNN();
        machineState = new MachineState();
    }

    @Test
    public void execute_skipNextInstruction() throws Exception {
        givenV(5, 0x20);
        executeOpCode(0x3520);
        assertPC(0x204);
    }

    @Test
    public void execute_dontSkipNextInstruction() throws Exception {
        givenV(5, 0x20);
        executeOpCode(0x3525);
        assertPC(0x200);
    }
}
