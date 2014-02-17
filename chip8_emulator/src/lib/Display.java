package lib;

import _main.DoubleBufferedWindow;

import java.awt.*;
import java.util.Arrays;

/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/14/14 at 8:27 PM
 */
public class Display {
    private DoubleBufferedWindow window;
    int pixels[] = new int[64 * 32];

    public Display(DoubleBufferedWindow window) {
        this.window = window;
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }

    public void draw() {
        int pixelSize = 32;
        Graphics g = window.getDrawGraphics();
        g.setColor(Color.white);
        for (int y = 0; y < 32; ++y)
            for (int x = 0; x < 64; ++x) {
                if (pixels[x + y * 64] != 0)
                    g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
    }

    public void setPixel(int x, int y) {
        pixels[x + y * 64] = 1;
    }
}
