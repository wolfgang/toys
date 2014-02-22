/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 8:45 PM
 */

package lib.OpCodes;

import lib.MachineState;

public abstract class OpCodeKeys implements OpCode {
    protected boolean isKeyInVXPressed(MachineState mc, int myCode)
    {
        int vX = (0x0F00 & myCode) >> 8;
        int keyIndex = 15 - mc.V[vX];
        int mask = 1 << keyIndex;
        return ((mc.keyboard & mask) == mask);
    }
}
