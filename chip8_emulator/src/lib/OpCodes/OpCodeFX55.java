/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:56 PM
 */

package lib.OpCodes;

import lib.MachineState;
import lib.Memory;

public class OpCodeFX55 extends OpCodeVX {
    private Memory memory;

    public OpCodeFX55(Memory memory) {
        this.memory = memory;
    }

    @Override
    protected void execute(MachineState mc, int myCode, int vX) {
        for (int i = 0; i<=vX; ++i)
            memory.set(mc.I + i, mc.V[i]);
    }

    public Memory getMemory() {
        return memory;
    }
}
