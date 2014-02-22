/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 8:26 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeEX9E implements OpCode {
    @Override
    public void execute(MachineState mc, int myCode) {
        int vX = (0x0F00 & myCode) >> 8;
        int keyIndex = 15 - mc.V[vX];
        int mask = 1 << keyIndex;
        if ((mc.keyboard & mask) == mask)
            mc.pc += 4;
    }
}
