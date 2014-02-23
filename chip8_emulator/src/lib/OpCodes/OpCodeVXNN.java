/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:28 PM
 */

package lib.OpCodes;

import lib.MachineState;

public abstract class OpCodeVXNN extends OpCodeVX {
    @Override
    public void execute(MachineState mc, int myCode, int vX) {
        int NN = 0x00FF & myCode;
        execute(mc, myCode, vX, NN);
    }

    abstract protected void execute(MachineState machineState, int myCode, int vX, int NN);
}
