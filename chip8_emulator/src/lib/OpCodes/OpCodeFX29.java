/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:24 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeFX29 extends OpCodeVX {
    @Override
    protected void execute(MachineState mc, int myCode, int vX) {
        mc.I = (0xFF & mc.V[vX])*5;
    }
}
