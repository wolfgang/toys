/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:21 PM
 */

package lib;

public class OpCodeFactory {
    private Screen screen;

    public OpCodeFactory(Screen screen) {
        this.screen = screen;
    }

    public OpCode getOpCode(int code) throws InvalidOpCode {
        if ((code & 0x1000) == 0x1000)
            return new OpCode1NNN(0x0FFF & code);

        if (code == 0x00E0)
            return new OpCode00E0(screen);

        throw new InvalidOpCode(code);
    }
}
