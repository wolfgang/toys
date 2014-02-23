/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 7:20 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode5XY0 extends OpCodeVXVY {
    @Override
    public void execute(MachineState mc, int myCode, int vx, int vy) {
        if (mc.V[vx] == mc.V[vy])
            mc.pc += 4;

    }
}
