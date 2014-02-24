/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 2:15 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY7 extends OpCodeVXVY {
    @Override
    protected void execute(MachineState mc, int myCode, int vX, int vY) {
        int vXValue = mc.V[vX];
        int vYValue = mc.V[vY];
        mc.V[vX] = (byte) ((vYValue - vXValue) & 0xFF);
        mc.V[15] = (byte) (vYValue<vXValue ? 0 : 1);
    }
}
