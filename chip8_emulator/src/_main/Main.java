/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 1/30/14 at 9:14 AM
 */

package _main;

import lib.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        DoubleBufferedWindow mainWindow = new DoubleBufferedWindow("Chip8 Emulator", 10, 10, 1024, 768);
        Display display = new Display(mainWindow);
        Memory memory = new Memory();
        memory.set(0x0000, 0b10101011);
        memory.set(0x0001, 0b10101110);
        memory.set(0x200, 0x00);
        memory.set(0x201, 0xE0);
        //memory.set(0x202, 0x12);
        //memory.set(0x203, 0x00);
        memory.set(0x202, 0xD1);
        memory.set(0x203, 0x22);
        memory.set(0x204, 0x12);
        memory.set(0x205, 0x00);
        OpCodeFactory opCodeFactory = new OpCodeFactory(display);
        MachineState machineState = new MachineState(memory);
        machineState.V[1] = 1;
        OpCodeDecoder opCodeDecoder = new OpCodeDecoder(machineState, opCodeFactory);
        Chip8Emulator emulator = new Chip8Emulator(machineState, display, opCodeDecoder);
        mainWindow.clear(Color.black);
        //noinspection InfiniteLoopStatement
        while(true)
        {
            emulator.tick();
            mainWindow.showBuffer();
            Thread.sleep(1);
        }
    }
}
