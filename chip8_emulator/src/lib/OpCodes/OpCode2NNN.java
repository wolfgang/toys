/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:40 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode2NNN implements OpCode {
    @Override
    public void execute(MachineState mc, int myCode) {
        mc.pushOntoStack(mc.pc + 2);
        mc.pc = (0x0FFF & myCode);
    }
}
