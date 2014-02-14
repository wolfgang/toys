/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/14/14 at 7:56 PM
 */

package lib;

public class Chip8Emulator {
    private boolean opCodesLoaded;
    private Screen screen;

    public Chip8Emulator(Screen screen) {
        this.screen = screen;
    }

    public boolean isRunning() {
        return true;
    }

    public void tick() {
        if (!opCodesLoaded)
            throw new RuntimeException("invalid program");
        else
            screen.clear();
    }

    public void loadProgram(int[] opCodes) {
        opCodesLoaded = true;
    }
}
