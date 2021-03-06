/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 1:52 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY5 extends OpCodeVXVY {
    @Override
    protected void execute(MachineState mc, int myCode, int vX, int vY) {
        char valueX = (char) mc.V[vX];
        char valueY = (char) mc.V[vY];

        mc.V[15] = (byte) (valueX>valueY ? 1 : 0);
        mc.V[vX] = (byte) ((valueX - valueY) & 0xFF);
    }
}
