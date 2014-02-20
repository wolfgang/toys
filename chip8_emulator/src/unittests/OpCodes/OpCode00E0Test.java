/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:04 PM
 */

package unittests.OpCodes;

import lib.MachineState;
import lib.OpCodes.OpCode00E0;
import lib.PixelBuffer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OpCode00E0Test {

    private PixelBuffer pixelBuffer;
    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        pixelBuffer = mock(PixelBuffer.class);
        machineState = new MachineState();
        machineState.pixelBuffer = pixelBuffer;
    }

    @Test
    public void execute_clearsTheScreen() throws Exception {
        OpCode00E0 opCode = new OpCode00E0();
        opCode.execute(machineState);
        verify(pixelBuffer).clear();
    }
}
