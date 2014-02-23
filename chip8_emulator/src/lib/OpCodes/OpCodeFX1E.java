/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:14 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeFX1E extends OpCodeVX {
    @Override
    protected void execute(MachineState mc, int myCode, int vX) {
        mc.I += mc.V[vX];
    }
}
