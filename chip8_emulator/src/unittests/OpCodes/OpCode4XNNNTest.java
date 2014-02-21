/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 6:26 PM
 */

package unittests.OpCodes;

import lib.MachineState;
import lib.OpCodes.OpCode4XNN;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCode4XNNNTest {
    private OpCode4XNN opCode;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        opCode = new OpCode4XNN();
        machineState = new MachineState();
    }

    @Test
    public void execute_skipNextInstruction() throws Exception {
        machineState.V[5] = 0x25;
        opCode.execute(machineState, 0x3520);
        assertThat(machineState.pc, is(0x204));
    }

    @Test
    public void execute_dontSkipNextInstruction() throws Exception {
        machineState.V[5] = 0x20;
        opCode.execute(machineState, 0x3520);
        assertThat(machineState.pc, is(0x200));
    }
}

