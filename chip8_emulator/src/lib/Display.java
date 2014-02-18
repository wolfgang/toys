package lib;

import java.awt.*;
import java.util.Arrays;

/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/14/14 at 8:27 PM
 */
public class Display {
    public static final int Width = 64;
    public static final int Height = 32;
    private Graphics graphics;
    private int pixelSize;
    byte pixels[] = new byte[Width * Height];

    public Display(Graphics graphics, int pixelSize) {
        this.graphics = graphics;
        this.pixelSize = pixelSize;
    }

    public void clear() {
        Arrays.fill(pixels, (byte)0);
    }

    public void draw() {
        graphics.setColor(Color.white);
        for (int y = 0; y < Height; ++y)
            for (int x = 0; x < Width; ++x) {
                if (isPixelSet(x, y))
                    graphics.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
    }

    public void setPixel(int x, int y) {
        pixels[x + y * Width] = 1;
    }

    public boolean isPixelSet(int x, int y) {
        return pixels[x + y * Width] != 0;
    }
}
