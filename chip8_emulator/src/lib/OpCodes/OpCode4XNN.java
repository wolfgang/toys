/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 6:27 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode4XNN implements OpCode {
    @Override
    public void execute(MachineState machineState, int myCode) {
        int vIndex = (0x0F00 & myCode) >> 8;
        int value = 0x00FF & myCode;
        if (value != machineState.V[vIndex])
            machineState.pc += 4;
    }
}