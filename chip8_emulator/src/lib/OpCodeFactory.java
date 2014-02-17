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

    public OpCode getOpCode(int code) {
        if ((code & 0x1000) == 0x1000)
        {
            int destination = 0x0FFF & code;
            return new OpCode1NNN(destination);
        }

        return new OpCode00E0(screen);
    }
}
