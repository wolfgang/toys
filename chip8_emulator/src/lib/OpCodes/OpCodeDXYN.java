/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 8:36 PM
 */

package lib.OpCodes;

import lib.Display;
import lib.MachineState;

public class OpCodeDXYN implements OpCode {
    private final Display display;
    private final int x;
    private final int y;
    private final int height;

    public OpCodeDXYN(Display display, int x, int y, int height) {

        this.display = display;
        this.x = x;
        this.y = y;
        this.height = height;
    }

    @Override
    public void execute(MachineState machineState) {
        for (int i = 0; i < height; ++i)
            drawSpriteRow(machineState, i);
    }

    private void drawSpriteRow(MachineState machineState, int verticalIndex) {
        int rowValue = machineState.memory.get(machineState.I + verticalIndex);
        int lineX = machineState.V[x];
        int lineY = machineState.V[y] + verticalIndex;
        for (int i = 7; i >= 0; --i) {
            if (isBitSet(i, rowValue)) {
                display.setPixel(lineX + (7 - i), lineY);
                machineState.V[15] = 1;
            }
        }
    }

    private boolean isBitSet(int bitIndex, int value) {
        int mask = 1 << bitIndex;
        return ((mask & value) == mask);
    }
}
