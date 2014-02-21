/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:31 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode6XNN extends OpCodeXNN {
    @Override
    public void execute(MachineState mc, int myCode, int vX, int NN) {
        mc.V[vX] = NN;
    }
}
