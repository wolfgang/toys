/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 8:36 PM
 */

package lib.OpCodes;

import lib.Display;
import lib.MachineState;
import lib.Memory;

public class OpCodeDXYN extends OpCodeXY {
    private int x;
    private int y;
    private boolean wasAnyPixelChanged;
    private Display display;
    private Memory memory;

    public OpCodeDXYN(Memory memory, Display display) {
        this.display = display;
        this.memory = memory;
    }

    @Override
    public void execute(MachineState mc, int myCode, int vX, int vY) {
        x = vX;
        y = vY;
        int height = (myCode & 0x000F);
        wasAnyPixelChanged = false;
        for (int i = 0; i < height; ++i)
            drawSpriteRow(mc, i);
        setVF(mc);

    }

    private void setVF(MachineState mc) {
        mc.V[15] = wasAnyPixelChanged ? 1 : 0;
    }

    private void drawSpriteRow(MachineState mc, int verticalIndex) {
        int rowValue = memory.get(mc.I + verticalIndex);
        int lineX = mc.V[x];
        int lineY = mc.V[y] + verticalIndex;
        for (int i = 7; i >= 0; --i) {
            int pixelX = lineX + (7 - i);
            if (!display.isPixelSet(pixelX, lineY) && isBitSet(i, rowValue)) {
                display.setPixel(pixelX, lineY);
                wasAnyPixelChanged = true;
            }

            if (display.isPixelSet(pixelX, lineY) && !isBitSet(i, rowValue)) {
                display.clearPixel(pixelX, lineY);
                wasAnyPixelChanged = true;
            }
        }
    }

    private boolean isBitSet(int bitIndex, int value) {
        int mask = 1 << bitIndex;
        return ((mask & value) == mask);
    }

    public Display getDisplay() {
        return display;
    }

    public Memory getMemory() {
        return memory;
    }
}
