/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:15 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY1 extends OpCodeVXVY {
    @Override
    public void execute(MachineState mc, int myCode, int vx, int vy) {
        mc.V[vx] = mc.V[vx] | mc.V[vy];
    }
}
