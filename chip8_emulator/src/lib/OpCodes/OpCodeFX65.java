/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 5:02 PM
 */

package lib.OpCodes;

import lib.MachineState;
import lib.Memory;

public class OpCodeFX65 extends OpCodeVX {
    private Memory memory;

    public OpCodeFX65(Memory memory) {
        this.memory = memory;
    }

    @Override
    protected void execute(MachineState mc, int myCode, int vX) {
        for (int i = 0; i<=vX; ++i)
            mc.V[i] = memory.get(mc.I + i);
    }

    public Memory getMemory() {
        return memory;
    }
}
