/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/18/14 at 8:06 AM
 */

package unittests;

import lib.Display;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.awt.*;

import static org.mockito.Mockito.*;

public class DisplayTest {

    private Graphics graphics;
    private Display display;
    private InOrder graphicsOrder;
    private int pixelSize = 64;

    @Before
    public void setUp() throws Exception {
        graphics = mock(Graphics.class);
        display = new Display(graphics, pixelSize);
        graphicsOrder = inOrder(graphics);
    }

    @Test
    public void newlyCreatedDisplayIsBlank() throws Exception {
        display.draw();
        verifySetColor();
        verifyNoFurtherGraphicsCalls();
    }

    @Test
    public void setPixel_00_drawsWhiteRectAt00() throws Exception {
        display.setPixel(0, 0);
        display.draw();
        verifySetColor();
        verifyFillRect(0, 0);
        verifyNoFurtherGraphicsCalls();
    }

    @Test
    public void setPixel_setSomePixels() throws Exception {
        display.setPixel(10, 20);
        display.setPixel(63, 31);
        display.draw();
        verifySetColor();
        verifyFillRect(10 * pixelSize, 20 * pixelSize);
        verifyFillRect(63*pixelSize, 31*pixelSize);
        verifyNoFurtherGraphicsCalls();
    }

    @Test
    public void clear_clearsAllPixels() throws Exception {
        display.setPixel(1, 2);
        display.setPixel(10, 20);
        display.clear();
        display.draw();
        verifySetColor();
        verifyNoFurtherGraphicsCalls();
    }

    private void verifySetColor() {
        graphicsOrder.verify(graphics).setColor(Color.white);
    }

    private void verifyNoFurtherGraphicsCalls() {
        verifyNoMoreInteractions(graphics);
    }

    private void verifyFillRect(int x, int y) {
        graphicsOrder.verify(graphics).fillRect(x, y, pixelSize, pixelSize);
    }
}
