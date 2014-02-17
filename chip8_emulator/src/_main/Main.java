/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 1/30/14 at 9:14 AM
 */

package _main;

import lib.Chip8Emulator;
import lib.OpCodeDecoder;
import lib.Screen;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DoubleBufferedWindow mainWindow = new DoubleBufferedWindow("Chip8 Emulator", 10, 10, 1024, 768);
        Screen screen = new Screen(mainWindow);
        OpCodeDecoder opCodeDecoder = new OpCodeDecoder(screen);
        Chip8Emulator emulator = new Chip8Emulator(screen, opCodeDecoder);
        //noinspection InfiniteLoopStatement
        while(true)
        {
            emulator.tick();
            mainWindow.showBuffer();
            Thread.sleep(1);
        }
    }
}
