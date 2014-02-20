/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:14 AM
 */

package unittests;

import lib.PixelBuffer;
import lib.PixelRenderer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class PixelBufferTest {

    private PixelRenderer pixelRenderer;
    private PixelBuffer pixelBuffer;

    @Before
    public void setUp() throws Exception {
        pixelRenderer = mock(PixelRenderer.class);
        pixelBuffer = new PixelBuffer(pixelRenderer);
    }

    @Test
    public void draw_newlyCreatedBuffer_doesNothing() throws Exception {
        pixelBuffer.draw();
        verifyNoMoreInteractions(pixelRenderer);
    }

    @Test
    public void draw_setPixelCausesPixelToBeDrawn() throws Exception {
        pixelBuffer.setPixel(0, 0);
        pixelBuffer.draw();
        verify(pixelRenderer).drawWhitePixel(0, 0);
    }

    @Test
    public void draw_setMultiplePixels() throws Exception {
        pixelBuffer.setPixel(1, 1);
        pixelBuffer.setPixel(20, 20);
        pixelBuffer.setPixel(63, 31);
        pixelBuffer.draw();
        verify(pixelRenderer).drawWhitePixel(1, 1);
        verify(pixelRenderer).drawWhitePixel(20, 20);
        verify(pixelRenderer).drawWhitePixel(63, 31);
        verifyNoMoreInteractions(pixelRenderer);
    }

    @Test
    public void draw_drawPixelOnlyOnceAfterSettingIt() throws Exception {
        pixelBuffer.setPixel(10, 20);
        pixelBuffer.draw();
        pixelBuffer.draw();
        verify(pixelRenderer).drawWhitePixel(10, 20);
    }

    @Test
    public void draw_clearPixelCausesBlackPixelToBeDrawn() throws Exception {
        pixelBuffer.clearPixel(10, 20);
        pixelBuffer.draw();
        pixelBuffer.draw();
        verify(pixelRenderer).drawBlackPixel(10, 20);

    }
}
