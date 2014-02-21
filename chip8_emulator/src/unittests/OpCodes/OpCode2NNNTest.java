/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:39 PM
 */

package unittests.OpCodes;

import lib.MachineState;
import lib.OpCodes.OpCode2NNN;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCode2NNNTest extends OpCodeTest {
    @Before
    public void setUp() throws Exception {
        machineState = new MachineState();
        opCode = new OpCode2NNN();
    }

    @Test
    public void execute() throws Exception {
        machineState.pc = 0x400;
        opCode.execute(machineState, 0x2600);
        assertPC(0x600);
        assertThat(machineState.popFromStack(), is(0x402));
    }
}
