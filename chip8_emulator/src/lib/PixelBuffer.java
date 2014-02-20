/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:16 AM
 */

package lib;

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
                if (pixels[x + y * Width] == 0b11) {
                    pixelRenderer.drawWhitePixel(x, y);
                    pixels[x + y * Width] = 0b01;
                }
                if (pixels[x + y * Width] == 0b10) {
                    pixelRenderer.drawBlackPixel(x, y);
                    pixels[x + y * Width] = 0b00;
                }
            }

    }

    public void setPixel(int x, int y) {
        pixels[x + y * Width] = 0b11;

    }

    public void clearPixel(int x, int y) {
        pixels[x + y * Width] = 0b10;
    }
}
