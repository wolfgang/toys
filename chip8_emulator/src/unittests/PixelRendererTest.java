/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:38 AM
 */

package unittests;

import lib.PixelRenderer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.awt.*;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class PixelRendererTest {
    private final int pixelSize = 32;
    private Graphics graphics;
    private PixelRenderer pixelRenderer;
    private InOrder graphicsOrder;

    @Before
    public void setUp() throws Exception {
        graphics = mock(Graphics.class);
        pixelRenderer = new PixelRenderer(graphics, pixelSize);
        graphicsOrder = inOrder(graphics);
    }

    @Test
    public void renderPixelWithColor_1_drawWhiteRect() throws Exception {

        pixelRenderer.drawPixel(10, 20, 1);
        verifySetColor(Color.white);
        verifyPixelSizedFillRect(10*pixelSize, 20*pixelSize);
    }

    @Test
    public void renderPixelWithColor_0_drawBlackRect() throws Exception {
        pixelRenderer.drawPixel(11, 21, 0);
        verifySetColor(Color.black);
        verifyPixelSizedFillRect(11*pixelSize, 21*pixelSize);
    }

    private void verifySetColor(Color color) {
        graphicsOrder.verify(graphics).setColor(color);
    }

    private void verifyPixelSizedFillRect(int x, int y) {
        graphicsOrder.verify(graphics).fillRect(x, y, pixelSize, pixelSize);
    }
}
