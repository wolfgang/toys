/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:14 PM
 */

package lib;

import lib.OpCodes.*;

public class OpCodeRegistryLoader {
    private final OpCodeRegistry opCodeRegistry;
    private final OpCodeFactory opCodeFactory;
    private final Memory memory;
    private final Display display;

    public OpCodeRegistryLoader(OpCodeRegistry opCodeRegistry, OpCodeFactory opCodeFactory, Memory memory, Display display) {

        this.opCodeRegistry = opCodeRegistry;
        this.opCodeFactory = opCodeFactory;
        this.memory = memory;
        this.display = display;
    }

    public void registerKnownOpCodes() {
        for (OpCodeId id : OpCodeId.values())
        {
            if (id != OpCodeId.OP_INVALID)
                registerNewOpCode(id);
        }

        opCodeRegistry.registerOpCode2(0x00E0, new OpCode00E0(display));
        opCodeRegistry.registerOpCode2(0x00EE, new OpCode00EE());
        opCodeRegistry.registerOpCode2(0x1000, new OpCode1NNN());
        opCodeRegistry.registerOpCode2(0x2000, new OpCode2NNN());
        opCodeRegistry.registerOpCode2(0x3000, new OpCode3XNN());
        opCodeRegistry.registerOpCode2(0x4000, new OpCode4XNN());
        opCodeRegistry.registerOpCode2(0x5000, new OpCode5XY0());
        opCodeRegistry.registerOpCode2(0x6000, new OpCode6XNN());
        opCodeRegistry.registerOpCode2(0x7000, new OpCode7XNN());
        opCodeRegistry.registerOpCode2(0x8000, new OpCode8XY0());
        opCodeRegistry.registerOpCode2(0x8001, new OpCode8XY1());
        opCodeRegistry.registerOpCode2(0x8002, new OpCode8XY2());
        opCodeRegistry.registerOpCode2(0x8003, new OpCode8XY3());
        opCodeRegistry.registerOpCode2(0xD000, new OpCodeDXYN(memory, display));
    }

    private void registerNewOpCode(OpCodeId id) {
        opCodeRegistry.registerOpCode(id, opCodeFactory.create(id));
    }
}

