/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:02 AM
 */

package lib;

public interface OpCode {
    void execute(MachineState machineState);
}
