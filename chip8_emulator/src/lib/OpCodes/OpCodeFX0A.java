/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 1:08 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeFX0A extends OpCodeVX {
    @Override
    protected void execute(MachineState mc, int myCode, int vX) {
        if (mc.keyboard>0) {
            mc.V[vX] = (int) (Math.log(mc.keyboard)/Math.log(2));
            mc.wait = false;
        } else
            mc.wait = true;
    }
}
