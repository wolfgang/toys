/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:04 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY0 implements OpCode {
    @Override
    public void execute(MachineState machineState, int myCode) {
        int vIndex1 = (0x0F00 & myCode) >> 8;
        int vIndex2 = (0x00F0 & myCode) >> 4;
        machineState.V[vIndex1] = machineState.V[vIndex2];

    }
}
