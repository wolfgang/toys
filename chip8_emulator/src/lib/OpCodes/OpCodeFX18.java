/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:07 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeFX18 extends OpCodeVX {
    @Override
    protected void execute(MachineState mc, int myCode, int vX) {
        mc.sound_timer = mc.V[vX] & 0xFF;
    }
}
