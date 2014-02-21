/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:05 PM
 */

package lib.OpCodes;

import lib.MachineState;
import lib.PixelBuffer;

public class OpCode00E0 implements OpCode {
    private PixelBuffer pixelBuffer;

    public OpCode00E0(PixelBuffer pixelBuffer) {
        this.pixelBuffer = pixelBuffer;
    }

    @Override
    public void execute(MachineState machineState, int myCode) {
        pixelBuffer.clear();
    }

    public PixelBuffer getPixelBuffer() {
        return pixelBuffer;
    }
}
