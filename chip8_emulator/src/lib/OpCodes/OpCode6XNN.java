/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:31 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode6XNN implements OpCode {
    @Override
    public void execute(MachineState machineState, int myCode) {
        int vIndex = (0x0F00 & myCode) >> 8;
        machineState.V[vIndex] = 0x00FF & myCode;
    }
}
