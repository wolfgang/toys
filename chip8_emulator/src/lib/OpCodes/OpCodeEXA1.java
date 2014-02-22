/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 8:41 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeEXA1 extends OpCodeKeys {
    @Override
    public void execute(MachineState mc, int myCode) {
        if (!isKeyInVXPressed(mc, myCode))
            mc.pc += 4;
    }

}
