/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 4:43 PM
 */

package unittests.OpCodes;

import lib.MachineState;
import lib.OpCodes.OpCode00EE;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCode00EETest {

    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        machineState = new MachineState();
    }

    @Test
    public void execute() throws Exception {
        OpCode00EE opCode = new OpCode00EE();
        machineState.pushOntoStack(0x300);
        opCode.execute(machineState, 0);
        assertThat(machineState.pc, is(0x300));
    }
}
