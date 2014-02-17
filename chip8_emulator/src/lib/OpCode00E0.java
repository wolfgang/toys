/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:05 PM
 */

package lib;

public class OpCode00E0 implements OpCode {
    private Screen screen;
    public OpCode00E0(Screen screen) {

        this.screen = screen;
    }

    @Override
    public void execute() {
        screen.clear();

    }
}
