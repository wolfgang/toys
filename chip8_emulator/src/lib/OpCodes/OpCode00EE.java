/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 4:44 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode00EE implements OpCode {
    @Override
    public void execute(MachineState mc, int myCode) {
        if (!mc.isStackEmpty())
            mc.pc = mc.popFromStack();

    }
}
