/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 1/30/14 at 9:14 AM
 */

package _main;

import lib.*;

import java.awt.*;
import java.io.IOException;

@SuppressWarnings("UnusedDeclaration")
public class Main {
    public static void main(String[] args) throws Exception {
        DoubleBufferedWindow mainWindow = new DoubleBufferedWindow("Chip8 Emulator", 10, 10, 1024, 768);
        Memory memory = new Memory();
        loadFont(memory);

        loadProgramFromFile("programs/fishie.ch8", memory);
        PixelRenderer pixelRenderer = new PixelRenderer(mainWindow.getDrawGraphics(), 12);
        Display display = new Display(mainWindow, pixelRenderer);
        MachineState machineState = new MachineState();
        KeyboardHandler keyboardHandler = new KeyboardHandler(machineState);
        mainWindow.addKeyListener(keyboardHandler);
        OpCodeResolver opCodeResolver = new OpCodeResolver();
        OpCodeRegistry opCodeRegistry = new OpCodeRegistry(opCodeResolver);
        OpCodeRegistryLoader opCodeRegistryLoader = new OpCodeRegistryLoader(opCodeRegistry, memory, display);
        opCodeRegistryLoader.registerKnownOpCodes();
        OpCodeExecutor opCodeExecutor = new OpCodeExecutor(opCodeRegistry, memory);
        Chip8Emulator emulator = new Chip8Emulator(machineState, opCodeExecutor, display);
        mainWindow.clear(Color.black);
        Timers timers = new Timers(machineState);

        long lastTick = System.currentTimeMillis();

        //noinspection InfiniteLoopStatement
        int tick = 0;
        while (true) {
            long now = System.currentTimeMillis();
            while (now - lastTick>=1) {
                //System.out.println("TICK " + now + " " + tick++);
                lastTick += 1;
                timers.tick();
                emulator.tick();
            }
            mainWindow.showBuffer();
            //Thread.sleep(1);
        }
    }

    private static void loadFont(Memory memory) {

        int fonts[] =
                {
                        0xF0, 0x90, 0x90, 0x90, 0xF0, // 0
                        0x20, 0x60, 0x20, 0x20, 0x70, // 1
                        0xF0, 0x10, 0xF0, 0x80, 0xF0, // 2
                        0xF0, 0x10, 0xF0, 0x10, 0xF0, // 3
                        0x90, 0x90, 0xF0, 0x10, 0x10, // 4
                        0xF0, 0x80, 0xF0, 0x10, 0xF0, // 5
                        0xF0, 0x80, 0xF0, 0x90, 0xF0, // 6
                        0xF0, 0x10, 0x20, 0x40, 0x40, // 7
                        0xF0, 0x90, 0xF0, 0x90, 0xF0, // 8
                        0xF0, 0x90, 0xF0, 0x10, 0xF0, // 9
                        0xF0, 0x90, 0xF0, 0x90, 0x90, // A
                        0xE0, 0x90, 0xE0, 0x90, 0xE0, // B
                        0xF0, 0x80, 0x80, 0x80, 0xF0, // C
                        0xE0, 0x90, 0x90, 0x90, 0xE0, // D
                        0xF0, 0x80, 0xF0, 0x80, 0xF0, // E
                        0xF0, 0x80, 0xF0, 0x80, 0x80  // F
                };

        for (int i = 0; i<fonts.length; ++i)
            memory.set(i, fonts[i]);
    }

    private static void loadProgramFromFile(String path, Memory memory) throws IOException {
        new ProgramLoader(memory).loadFromFile(path);
    }

    private static void loadProgram(Memory memory) {
        memory.set(0x0000, 0b10101011);
        memory.set(0x0001, 0b10101110);
        //memory.set(0x200, 0x00);
        //memory.set(0x201, 0xE0);
        memory.set(0x200, 0xD1);
        memory.set(0x201, 0x22);
        memory.set(0x202, 0x12);
        memory.set(0x203, 0x00);
    }

    private static void loadProgram2(Memory memory) {
        memory.set(0x0000, 0b10101011);
        memory.set(0x0001, 0b10101110);
        //memory.set(0x200, 0x00);
        //memory.set(0x201, 0xE0);
        memory.set(0x200, 0x26);
        memory.set(0x201, 0x00);
        memory.set(0x202, 0x12);
        memory.set(0x203, 0x00);
        memory.set(0x600, 0xD1);
        memory.set(0x601, 0x22);
        memory.set(0x602, 0x00);
        memory.set(0x603, 0xEE);
    }

    private static void loadProgram3(Memory memory) {
        memory.set(0x0000, 0b10101011);
        memory.set(0x0001, 0b10101110);
        //memory.set(0x200, 0x00);
        //memory.set(0x201, 0xE0);
        memory.set(0x200, 0x26);
        memory.set(0x201, 0x00);
        memory.set(0x202, 0x12);
        memory.set(0x203, 0x00);

        memory.set(0x600, 0x65);
        memory.set(0x601, 0x00);
        memory.set(0x602, 0xE5);
        memory.set(0x603, 0xA1);
        memory.set(0x604, 0xD1);
        memory.set(0x605, 0x22);
        memory.set(0x606, 0x00);
        memory.set(0x607, 0xEE);
    }


}
