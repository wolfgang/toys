/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 4:27 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeANNN implements OpCode {
    @Override
    public void execute(MachineState mc, int myCode) {
        mc.I = 0x0FFF & myCode;
    }
}
