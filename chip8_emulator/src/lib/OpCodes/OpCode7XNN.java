/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:50 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode7XNN extends OpCodeVXNN {
    @Override
    public void execute(MachineState mc, int myCode, int vX, int NN) {
        mc.V[vX] += NN;

    }
}
