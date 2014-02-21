/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:40 PM
 */

package lib;

public class MachineState {
    public int pc = 0x200;
    public int[] V = new int[16];
    public int I = 0;
    public Memory memory;
    public Display display;
}
