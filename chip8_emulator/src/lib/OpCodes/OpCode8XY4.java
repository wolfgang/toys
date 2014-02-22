/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 12:01 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY4 extends OpCodeXY {
    @Override
    protected void execute(MachineState mc, int myCode, int vX, int vY) {
        int sum = mc.V[vX] + mc.V[vY];
        int vF = (0x8000 & sum) == 0x8000 ? 1 : 0;
        mc.V[vX] = sum;
        mc.V[15] = vF;
    }
}
