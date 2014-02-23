/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:41 PM
 */

package lib.OpCodes;

import lib.MachineState;
import lib.Memory;

public class OpCodeFX33 extends OpCodeVX {
    private Memory memory;

    public OpCodeFX33(Memory memory) {
        this.memory = memory;
    }

    @Override
    protected void execute(MachineState mc, int myCode, int vX) {
        int vXValue = mc.V[vX];
        int d1 = vXValue/100;
        int d2 = (vXValue - d1*100)/10;
        int d3 = (vXValue - d1*100 - d2*10);
        memory.set(mc.I, d1);
        memory.set(mc.I + 1, d2);
        memory.set(mc.I + 2, d3);
    }

    public Memory getMemory() {
        return memory;
    }
}
