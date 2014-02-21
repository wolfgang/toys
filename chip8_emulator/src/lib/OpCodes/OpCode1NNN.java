/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:56 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode1NNN implements OpCode {
    @Override
    public void execute(MachineState mc, int myCode) {
        mc.pc = 0x0FFF & myCode;
    }
}
