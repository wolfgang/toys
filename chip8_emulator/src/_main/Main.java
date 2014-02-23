/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 1/30/14 at 9:14 AM
 */

package _main;

import lib.*;

import java.awt.*;

@SuppressWarnings("UnusedDeclaration")
public class Main {
    public static void main(String[] args) throws Exception {
        DoubleBufferedWindow mainWindow = new DoubleBufferedWindow("Chip8 Emulator", 10, 10, 1024, 768);
        Memory memory = new Memory();
        loadProgram3(memory);
        PixelRenderer pixelRenderer = new PixelRenderer(mainWindow.getDrawGraphics(), 16);
        Display display = new Display(pixelRenderer);
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

        //noinspection InfiniteLoopStatement
        while(true)
        {
            emulator.tick();
            mainWindow.showBuffer();
            Thread.sleep(1);
        }
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
