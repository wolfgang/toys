/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:55 PM
 */

package unittests;

import lib.MachineState;
import lib.OpCode1NNN;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OpCode1NNNTest {
    @Test
    public void execute_changePCToNNN() throws Exception {
        MachineState machineState = new MachineState();
        OpCode1NNN opCode = new OpCode1NNN(0x400);
        opCode.execute(machineState);
        assertThat(machineState.pc, is(0x400));
    }
}
