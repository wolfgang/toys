/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 1/30/14 at 9:14 AM
 */

package _main;

import lib.Chip8Emulator;
import lib.Screen;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DoubleBufferedWindow mainWindow = new DoubleBufferedWindow("Chip8 Emulator", 10, 10, 1024, 768);
        Chip8Emulator emulator = new Chip8Emulator(new Screen(mainWindow));
        emulator.loadProgram(new int[] {123});
        while(emulator.isRunning())
        {
            emulator.tick();
            mainWindow.showBuffer();
            Thread.sleep(1);
        }
    }
}
