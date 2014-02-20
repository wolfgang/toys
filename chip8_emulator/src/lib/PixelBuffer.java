/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:16 AM
 */

package lib;

import java.util.Arrays;

public class PixelBuffer {
    public static final int Width = 64;
    public static final int Height = 32;
    byte pixels[] = new byte[Width * Height];
    private PixelRenderer pixelRenderer;

    public PixelBuffer(PixelRenderer pixelRenderer) {

        this.pixelRenderer = pixelRenderer;
    }

    public void draw() {
        for (int y = 0; y < Height; ++y)
            for (int x = 0; x < Width; ++x) {
                byte value = getPixelValue(x, y);
                if ((value & 0b10) == 0b10) {
                    int color = value & 0b01;
                    pixelRenderer.drawPixel(x, y, color);
                    setPixelValue(x, y, color);
                }
            }
    }

    public void setPixel(int x, int y) {
        setPixelValue(x, y, 0b11);
    }

    public void clearPixel(int x, int y) {
        setPixelValue(x, y, 0b10);
    }

    public void clear()
    {
        Arrays.fill(pixels, (byte)0b10);
    }

    private void setPixelValue(int x, int y, int value) {
        pixels[x + y * Width] = (byte) value;
    }

    private byte getPixelValue(int x, int y) {
        return pixels[x + y * Width];
    }

    public boolean isPixelSet(int x, int y) {
        return (getPixelValue(x, y) & 0b01) == 0b01;
    }
}
