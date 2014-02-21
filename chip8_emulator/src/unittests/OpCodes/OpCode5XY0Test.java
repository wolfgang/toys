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
    public void execute_skipInstruction() throws Exception {
        machineState.V[2] = 10;
        machineState.V[12] = 10;
        opCode.execute(machineState, 0x52C0);
        assertPC(0x204);
    }

    @Test
    public void execute_dontSkipInstruction() throws Exception {
        machineState.V[5] = 10;
        machineState.V[1] = 20;
        opCode.execute(machineState, 0x5510);
        assertPC(0x200);
    }

}
