/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:35 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY2 extends OpCodeXY {
    @Override
    protected void execute(MachineState mc, int myCode, int vX, int vY) {
        mc.V[vX] = mc.V[vX] & mc.V[vY];
    }
}
