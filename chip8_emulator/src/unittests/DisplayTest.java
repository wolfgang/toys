/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:14 AM
 */

package unittests;

import lib.Display;
import lib.PixelRenderer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class DisplayTest {

    private PixelRenderer pixelRenderer;
    private Display display;

    @Before
    public void setUp() throws Exception {
        pixelRenderer = mock(PixelRenderer.class);
        display = new Display(pixelRenderer);
    }

    @Test
    public void draw_newlyCreatedBuffer_doesNothing() throws Exception {
        display.draw();
        verifyNoMoreInteractions(pixelRenderer);
    }

    @Test
    public void draw_setPixelCausesPixelToBeDrawn() throws Exception {
        display.setPixel(0, 0);
        display.draw();
        verify(pixelRenderer).drawPixel(0, 0, 1);
    }

    @Test
    public void draw_setMultiplePixels() throws Exception {
        display.setPixel(1, 1);
        display.setPixel(20, 20);
        display.setPixel(63, 31);
        display.draw();
        verify(pixelRenderer).drawPixel(1, 1, 1);
        verify(pixelRenderer).drawPixel(20, 20, 1);
        verify(pixelRenderer).drawPixel(63, 31, 1);
        verifyNoMoreInteractions(pixelRenderer);
    }

    @Test
    public void draw_drawPixelOnlyOnceAfterSettingIt() throws Exception {
        display.setPixel(10, 20);
        display.draw();
        display.draw();
        verify(pixelRenderer).drawPixel(10, 20, 1);
    }

    @Test
    public void draw_clearPixelCausesBlackPixelToBeDrawn() throws Exception {
        display.clearPixel(10, 20);
        display.draw();
        display.draw();
        verify(pixelRenderer).drawPixel(10, 20, 0);

    }

    @Test
    public void isPixelSet() throws Exception {
        display.setPixel(10, 20);
        assertThat(display.isPixelSet(10, 20), is(true));
        assertThat(display.isPixelSet(11, 21), is(false));
    }
}
