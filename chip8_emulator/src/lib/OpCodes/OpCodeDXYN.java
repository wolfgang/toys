/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 8:36 PM
 */

package lib.OpCodes;

import lib.MachineState;
import lib.PixelBuffer;

public class OpCodeDXYN implements OpCode {
    private int x;
    private int y;
    private int height;
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

    @Override
    public void execute(MachineState machineState, int myCode) {
        this.x = (myCode & 0x0F00) >> 8;
        this.y = (myCode & 0x00F0) >> 4;
        this.height = (myCode & 0x000F);
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
        PixelBuffer pixelBuffer = machineState.pixelBuffer;
        for (int i = 7; i >= 0; --i) {
            int pixelX = lineX + (7 - i);
            if (!pixelBuffer.isPixelSet(pixelX, lineY) && isBitSet(i, rowValue)) {
                pixelBuffer.setPixel(pixelX, lineY);
                wasAnyPixelChanged = true;
            }

            if (pixelBuffer.isPixelSet(pixelX, lineY) && !isBitSet(i, rowValue)) {
                pixelBuffer.clearPixel(pixelX, lineY);
                wasAnyPixelChanged = true;
            }
        }
    }

    private boolean isBitSet(int bitIndex, int value) {
        int mask = 1 << bitIndex;
        return ((mask & value) == mask);
    }
}
