/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:02 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeFX15 extends OpCodeVX {
    @Override
    protected void execute(MachineState mc, int myCode, int vX) {
        mc.delay_timer = mc.V[vX];
    }
}
