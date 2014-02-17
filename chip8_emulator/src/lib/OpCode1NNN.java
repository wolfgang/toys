/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:56 PM
 */

package lib;

public class OpCode1NNN implements OpCode {
    private int destination;

    public OpCode1NNN(int destination) {
        this.destination = destination;
    }

    public void execute(MachineState machineState) {
        machineState.pc = destination;
    }

    public int getDestination() {
        return destination;
    }
}
