/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 2:15 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY7 extends OpCodeVXVY {
    @Override
    protected void execute(MachineState mc, int myCode, int vX, int vY) {
        char vXValue = (char) mc.V[vX];
        char vYValue = (char) mc.V[vY];
        mc.V[vX] = (byte) (vYValue - vXValue);
        mc.V[15] = (byte) (vYValue<vXValue ? 0 : 1);
    }
}
