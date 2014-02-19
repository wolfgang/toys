/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/18/14 at 8:06 AM
 */

package unittests;

import lib.OldDisplay;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class OldDisplayTest {

    private Graphics graphics;
    private OldDisplay oldDisplay;
    private InOrder graphicsOrder;
    private int pixelSize = 64;

    @Before
    public void setUp() throws Exception {
        graphics = mock(Graphics.class);
        oldDisplay = new OldDisplay(graphics, pixelSize);
        graphicsOrder = inOrder(graphics);
    }

    @Test
    public void newlyCreatedDisplayIsBlank() throws Exception {
        oldDisplay.draw();
        verifySetColor();
        verifyNoFurtherGraphicsCalls();
    }

    @Test
    public void setPixel_00_drawsWhiteRectAt00() throws Exception {
        oldDisplay.setPixel(0, 0);
        oldDisplay.draw();
        verifySetColor();
        verifyFillRect(0, 0);
        verifyNoFurtherGraphicsCalls();
    }

    @Test
    public void setPixel_setSomePixels() throws Exception {
        oldDisplay.setPixel(10, 20);
        oldDisplay.setPixel(63, 31);
        oldDisplay.draw();
        verifySetColor();
        verifyFillRect(10 * pixelSize, 20 * pixelSize);
        verifyFillRect(63*pixelSize, 31*pixelSize);
        verifyNoFurtherGraphicsCalls();
    }

    @Test
    public void clear_clearsAllPixels() throws Exception {
        oldDisplay.setPixel(1, 2);
        oldDisplay.setPixel(10, 20);
        oldDisplay.clear();
        oldDisplay.draw();
        verifySetColor();
        verifyNoFurtherGraphicsCalls();
    }

    @Test
    public void isPixelSet() throws Exception {
        oldDisplay.setPixel(1, 2);
        assertThat(oldDisplay.isPixelSet(1, 2), is(true));
        assertThat(oldDisplay.isPixelSet(10, 20), is(false));
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
