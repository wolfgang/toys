/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:56 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class OpCode1NNN implements OpCode {
    private int destination;

    public OpCode1NNN(int code) {
        this.destination = 0x0FFF & code;
    }

    public void execute(MachineState machineState) {
        machineState.pc = destination;
    }

    public int getDestination() {
        return destination;
    }
}
