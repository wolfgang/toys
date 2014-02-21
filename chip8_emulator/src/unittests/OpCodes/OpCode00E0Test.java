/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:04 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode00E0;
import lib.PixelBuffer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OpCode00E0Test {

    private PixelBuffer pixelBuffer;

    @Before
    public void setUp() throws Exception {
        pixelBuffer = mock(PixelBuffer.class);
    }

    @Test
    public void execute_clearsTheScreen() throws Exception {
        OpCode00E0 opCode = new OpCode00E0(pixelBuffer);
        opCode.execute(null, 0);
        verify(pixelBuffer).clear();
    }
}
