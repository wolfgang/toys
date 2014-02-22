/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:14 PM
 */

package lib;

import lib.OpCodes.*;

public class OpCodeRegistryLoader {
    private final OpCodeRegistry opCodeRegistry;
    private final Memory memory;
    private final Display display;

    public OpCodeRegistryLoader(OpCodeRegistry opCodeRegistry, Memory memory, Display display) {
        this.opCodeRegistry = opCodeRegistry;
        this.memory = memory;
        this.display = display;
    }

    public void registerKnownOpCodes() {
        opCodeRegistry.registerOpCode(0x00E0, new OpCode00E0(display));
        opCodeRegistry.registerOpCode(0x00EE, new OpCode00EE());
        opCodeRegistry.registerOpCode(0x1000, new OpCode1NNN());
        opCodeRegistry.registerOpCode(0x2000, new OpCode2NNN());
        opCodeRegistry.registerOpCode(0x3000, new OpCode3XNN());
        opCodeRegistry.registerOpCode(0x4000, new OpCode4XNN());
        opCodeRegistry.registerOpCode(0x5000, new OpCode5XY0());
        opCodeRegistry.registerOpCode(0x6000, new OpCode6XNN());
        opCodeRegistry.registerOpCode(0x7000, new OpCode7XNN());
        opCodeRegistry.registerOpCode(0x8000, new OpCode8XY0());
        opCodeRegistry.registerOpCode(0x8001, new OpCode8XY1());
        opCodeRegistry.registerOpCode(0x8002, new OpCode8XY2());
        opCodeRegistry.registerOpCode(0x8003, new OpCode8XY3());
        opCodeRegistry.registerOpCode(0x8004, new OpCode8XY4());
        opCodeRegistry.registerOpCode(0x8005, new OpCode8XY5());
        opCodeRegistry.registerOpCode(0x8006, new OpCode8XY6());
        opCodeRegistry.registerOpCode(0x8007, new OpCode8XY7());
        opCodeRegistry.registerOpCode(0x800E, new OpCode8XYE());
        opCodeRegistry.registerOpCode(0x9000, new OpCode9XY0());
        opCodeRegistry.registerOpCode(0xD000, new OpCodeDXYN(memory, display));
    }
}

