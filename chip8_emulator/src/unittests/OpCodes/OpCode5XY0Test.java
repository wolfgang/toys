/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:19 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode5XY0;
import org.junit.Before;
import org.junit.Test;

public class OpCode5XY0Test extends OpCodeTest {
    @Before
    public void setUp() {
        opCode = new OpCode5XY0();
    }

    @Test
    public void execute_skipInstruction_because_VX_equals_VY() throws Exception {
        givenV(2, 10);
        givenV(12, 10);
        executeOpCode(0x52C0);
        assertPC(0x204);
    }

    @Test
    public void execute_dontSkipInstruction_because_VX_not_equals_VY() throws Exception {
        givenV(5, 10);
        givenV(1, 20);
        executeOpCode(0x5510);
        assertPC(0x200);
    }

}
