/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 8:15 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode8XY1 implements OpCode {
    @Override
    public void execute(MachineState mc, int myCode) {
        int vIndex1 = (0x0F00 & myCode) >> 8;
        int vIndex2 = (0x00F0 & myCode) >> 4;
        mc.V[vIndex1] = mc.V[vIndex1] | mc.V[vIndex2];
    }
}
