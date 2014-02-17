/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:05 PM
 */

package lib.OpCodes;

import lib.MachineState;
import lib.Display;

public class OpCode00E0 implements OpCode {
    private Display display;

    public OpCode00E0(Display display) {
        this.display = display;
    }

    @Override
    public void execute(MachineState machineState) {
        display.clear();
    }

    public Display getDisplay() {
        return display;
    }
}
