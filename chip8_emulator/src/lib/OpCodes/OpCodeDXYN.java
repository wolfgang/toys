/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 8:36 PM
 */

package lib.OpCodes;

import lib.Display;
import lib.MachineState;
import lib.Memory;

public class OpCodeDXYN extends OpCodeVXVY {
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
        for (int i = 0; i<height; ++i)
            drawSpriteRow(mc, i);
        setVF(mc);
        mc.draw = true;

    }

    private void setVF(MachineState mc) {
        mc.V[15] = (byte) (wasAnyPixelChanged ? 1 : 0);
    }

    private void drawSpriteRow(MachineState mc, int verticalIndex) {
        int rowValue = memory.get(mc.I + verticalIndex);
        int lineX = mc.V[x] & 0xFF;
        int lineY = (mc.V[y] &0xFF) + verticalIndex;
        for (int i = 7; i>=0; --i) {
            int pixelX = lineX + (7 - i);
            if (pixelX < 0 || pixelX > 63 || lineY < 0 || lineY > 31)
                continue;

            /*

            if((pixel & (0x80 >> xline)) != 0)
            {
                if(gfx[(x + xline + ((y + yline) * 64))] == 1)
                    V[0xF] = 1;
                gfx[x + xline + ((y + yline) * 64)] ^= 1;
            }
              */


            if (isBitSet(i, rowValue)) {
                if (display.isPixelSet(pixelX, lineY))
                    wasAnyPixelChanged = true;

                if (display.isPixelSet(pixelX, lineY))
                    display.clearPixel(pixelX, lineY);
                else if (!display.isPixelSet(pixelX, lineY))
                    display.setPixel(pixelX, lineY);
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
