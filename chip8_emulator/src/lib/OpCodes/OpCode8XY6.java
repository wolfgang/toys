/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 2:04 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY6 extends OpCodeVXVY {
    @Override
    protected void execute(MachineState mc, int myCode, int vX, int vY) {
        int vxValue = mc.V[vX];
        int lsb = 0x0001 & vxValue;
        mc.V[vX] = (byte) (vxValue >> 1);
        mc.V[15] = (byte) lsb;

    }
}
