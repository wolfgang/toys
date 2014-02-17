/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:00 AM
 */

package lib;

public class Chip8Emulator {
    private final Screen screen;
    private final OpCodeDecoder opCodeDecoder;

    public Chip8Emulator(
            Screen screen,
            OpCodeDecoder opCodeDecoder)
    {
        this.screen = screen;
        this.opCodeDecoder = opCodeDecoder;
    }

    public void tick()
    {
        OpCode opCode = opCodeDecoder.getNext();
        opCode.process();
        screen.draw();
    }
}
