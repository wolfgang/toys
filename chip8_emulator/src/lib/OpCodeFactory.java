/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:21 PM
 */

package lib;

import lib.OpCodes.OpCode;
import lib.OpCodes.OpCode00E0;
import lib.OpCodes.OpCode1NNN;

public class OpCodeFactory {
    private Display display;

    public OpCodeFactory(Display display) {
        this.display = display;
    }

    public OpCode getOpCode(int code) throws InvalidOpCode {
        if ((code & 0x1000) == 0x1000)
            return new OpCode1NNN(0x0FFF & code);

        if (code == 0x00E0)
            return new OpCode00E0(display);

        throw new InvalidOpCode(code);
    }
}
