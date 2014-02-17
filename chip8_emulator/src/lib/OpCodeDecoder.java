/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:01 AM
 */

package lib;

public class OpCodeDecoder {
    private Screen screen;

    public OpCodeDecoder(Screen screen) {
        this.screen = screen;
    }

    public OpCode getNext() {
        return new OpCode00E0(screen);
    }
}
