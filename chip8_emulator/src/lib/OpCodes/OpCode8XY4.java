/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 12:01 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY4 extends OpCodeVXVY {
    @Override
    protected void execute(MachineState mc, int myCode, int vX, int vY) {
        int sum = (char)mc.V[vX] + (char)mc.V[vY];
        int vF = sum > 0xFF ? 1 : 0;
        mc.V[vX] = (byte) sum;
        mc.V[15] = (byte) vF;
    }
}
