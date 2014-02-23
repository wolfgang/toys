/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:14 PM
 */

package unittests.OpCodes;

import lib.MachineState;
import lib.Memory;
import lib.OpCodes.OpCode;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCodeTest {
    protected MachineState machineState = new MachineState();
    protected OpCode opCode;
    protected Memory memory = new Memory();

    protected void givenPC(int value) {
        machineState.pc = value;
    }

    protected void givenVF(int value) {
        givenV(15, value);
    }

    protected void givenV(int index, int value) {
        machineState.V[index] = value;
    }

    protected void assertPC(int pc) {
        assertThat(machineState.pc, is(pc));
    }

    protected void assertVF(int value) {
        assertV(15, value);
    }

    protected void assertV(int index, int value) {
        assertThat(machineState.V[index], is(value));
    }

    protected void executeOpCode(int code) {
        opCode.execute(machineState, code);
    }

    protected void givenDelayTimer(int value) {
        machineState.delay_timer = value;
    }

    protected void givenI(int value) {
        machineState.I = value;
    }

    protected void assertI(int value) {
        assertThat(machineState.I, is(value));
    }

    protected void assertMemory(int address, int value) {
        assertThat(memory.get(address), is((byte) value));
    }

    protected void givenMemory(int address, int value) {
        memory.set(address, value);
    }
}
