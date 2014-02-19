/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:05 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode00E0 implements OpCode {
    @Override
    public void execute(MachineState machineState) {
        machineState.oldDisplay.clear();
    }
}
