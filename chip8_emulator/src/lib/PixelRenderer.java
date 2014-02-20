/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:16 AM
 */

package lib;

import java.awt.*;

public class PixelRenderer {
    private final Graphics graphics;
    private final int pixelSize;

    public PixelRenderer(Graphics graphics, int pixelSize) {
        this.graphics = graphics;
        this.pixelSize = pixelSize;
    }

    public void drawPixel(int x, int y, int color) {
        graphics.setColor(color == 1 ? Color.white : Color.black);
        graphics.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
    }
}
