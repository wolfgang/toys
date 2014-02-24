/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 2:21 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XYE extends OpCodeVXVY {
    @Override
    protected void execute(MachineState mc, int myCode, int vX, int vY) {
        char vXValue = (char) mc.V[vX];
        int msb = (0x80 & vXValue) >> 7;
        mc.V[vX] = (byte) (vXValue << 1);
        mc.V[15] = (byte) msb;
    }
}
