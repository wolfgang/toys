/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 4:33 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeBNNN implements OpCode {
    @Override
    public void execute(MachineState mc, int myCode) {
        int v0Value = mc.V[0];
        int NNN = 0x0FFF & myCode;
        mc.pc = v0Value + NNN;
    }
}
