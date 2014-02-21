/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:40 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode2NNN implements OpCode {
    @Override
    public void execute(MachineState machineState, int myCode) {
        machineState.pushOntoStack(machineState.pc + 2);
        machineState.pc = (0x0FFF & myCode);
    }
}
