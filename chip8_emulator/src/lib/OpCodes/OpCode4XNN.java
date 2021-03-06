/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 6:27 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode4XNN extends OpCodeVXNN {
    @Override
    public void execute(MachineState mc, int myCode, int vX, byte NN) {
        if (NN != mc.V[vX])
            mc.pc += 4;
    }
}