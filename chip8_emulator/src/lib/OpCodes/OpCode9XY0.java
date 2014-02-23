/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 2:39 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode9XY0 extends OpCodeVXVY {
    @Override
    protected void execute(MachineState mc, int myCode, int vX, int vY) {
        if (mc.V[vX] != mc.V[vY])
            mc.pc += 4;
    }
}
