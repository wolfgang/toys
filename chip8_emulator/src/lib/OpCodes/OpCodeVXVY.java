/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:21 PM
 */

package lib.OpCodes;

import lib.MachineState;

public abstract class OpCodeVXVY implements OpCode {
    @Override
    public void execute(MachineState machineState, int myCode) {
        int vX = (0x0F00 & myCode) >> 8;
        int vY = (0x00F0 & myCode) >> 4;
        execute(machineState, myCode, vX, vY);

    }

    abstract protected void execute(MachineState machineState, int myCode, int vX, int vY);
}
