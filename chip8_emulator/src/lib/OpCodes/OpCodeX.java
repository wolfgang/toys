/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 12:43 PM
 */

package lib.OpCodes;

import lib.MachineState;

public abstract class OpCodeX implements OpCode {
    @Override
    public void execute(MachineState mc, int myCode) {
        int vX = (0x0F00 & myCode) >> 8;
        execute(mc, myCode, vX);

    }

    abstract protected void execute(MachineState machineState, int myCode, int vX);
}
