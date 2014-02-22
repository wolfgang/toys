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

    protected void givenVF(int value)
    {
        givenVX(15, value);
    }
    protected void givenVX(int index, int value)
    {
        machineState.V[index] = value;
    }

    protected void assertPC(int pc) {
        assertThat(machineState.pc, is(pc));
    }

    protected void assertVF(int value) {
        assertVX(15, value);
    }

    protected void assertVX(int index, int value) {
        assertThat(machineState.V[index], is(value));
    }

    protected void executeOpCode(int code) {
        opCode.execute(machineState, code);
    }
}
