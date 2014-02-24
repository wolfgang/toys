/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 12:47 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeFX07 extends OpCodeVX {
    @Override
    protected void execute(MachineState mc, int myCode, int vX) {
        mc.V[vX] = (byte) mc.delay_timer;
    }
}
