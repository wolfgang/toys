/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:14 PM
 */

package unittests.OpCodes;

import lib.MachineState;
import lib.OpCodes.OpCode;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCodeTest {
    protected MachineState machineState = new MachineState();
    protected OpCode opCode;

    protected void assertPC(int pc) {
        assertThat(machineState.pc, is(pc));
    }
}
