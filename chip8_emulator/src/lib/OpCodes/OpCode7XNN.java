/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:50 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode7XNN implements OpCode {
    @Override
    public void execute(MachineState machineState, int myCode) {
        int vIndex = (0x0F00 & myCode) >> 8;
        int value = 0x00FF & myCode;
        machineState.V[vIndex] += value;

    }
}
