/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 8:26 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCodeEX9E extends OpCodeKeys {
    @Override
    public void execute(MachineState mc, int myCode) {
        if (isKeyInVXPressed(mc, myCode))
            mc.pc += 4;
    }
}
