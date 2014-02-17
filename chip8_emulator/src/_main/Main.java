/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 1/30/14 at 9:14 AM
 */

package _main;

import lib.*;

public class Main {
    public static void main(String[] args) throws Exception {
        DoubleBufferedWindow mainWindow = new DoubleBufferedWindow("Chip8 Emulator", 10, 10, 1024, 768);
        Display display = new Display(mainWindow);
        Memory memory = new Memory();
        memory.set(0x200, 0x00);
        memory.set(0x201, 0xE0);
        memory.set(0x202, 0x12);
        memory.set(0x203, 0x00);
        OpCodeFactory opCodeFactory = new OpCodeFactory(display);
        OpCodeDecoder opCodeDecoder = new OpCodeDecoder(memory, opCodeFactory);
        Chip8Emulator emulator = new Chip8Emulator(new MachineState(), display, opCodeDecoder);
        //noinspection InfiniteLoopStatement
        while(true)
        {
            emulator.tick();
            mainWindow.showBuffer();
            Thread.sleep(1);
        }
    }
}
