/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 8:36 PM
 */

package lib.OpCodes;

import lib.OldDisplay;
import lib.MachineState;

public class OpCodeDXYN implements OpCode {
    private final int x;
    private final int y;
    private final int height;
    private boolean wasAnyPixelChanged;

    public OpCodeDXYN(int code) {

        this.x = (code & 0x0F00) >> 8;
        this.y = (code & 0x00F0) >> 4;
        this.height = (code & 0x000F);
    }

    @Override
    public void execute(MachineState machineState) {
        wasAnyPixelChanged = false;
        for (int i = 0; i < height; ++i)
            drawSpriteRow(machineState, i);
        setVF(machineState);
    }

    private void setVF(MachineState machineState) {
        machineState.V[15] = wasAnyPixelChanged ? 1 : 0;
    }

    public String toString()
    {
        return x + " " + y + " " + height;
    }

    private void drawSpriteRow(MachineState machineState, int verticalIndex) {
        int rowValue = machineState.memory.get(machineState.I + verticalIndex);
        int lineX = machineState.V[x];
        int lineY = machineState.V[y] + verticalIndex;
        OldDisplay oldDisplay = machineState.oldDisplay;
        for (int i = 7; i >= 0; --i) {
            int pixelX = lineX + (7 - i);
            if (!oldDisplay.isPixelSet(pixelX, lineY) && isBitSet(i, rowValue)) {
                oldDisplay.setPixel(pixelX, lineY);
                wasAnyPixelChanged = true;
            }

            if (oldDisplay.isPixelSet(pixelX, lineY) && !isBitSet(i, rowValue)) {
                oldDisplay.clearPixel(pixelX, lineY);
                wasAnyPixelChanged = true;
            }
        }
    }

    private boolean isBitSet(int bitIndex, int value) {
        int mask = 1 << bitIndex;
        return ((mask & value) == mask);
    }
}
