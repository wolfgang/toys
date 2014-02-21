/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:14 PM
 */

package lib;

public class OpCodeRegistryInitializer {
    private final OpCodeRegistry opCodeRegistry;
    private final OpCodeFactory opCodeFactory;

    public OpCodeRegistryInitializer(OpCodeRegistry opCodeRegistry, OpCodeFactory opCodeFactory) {

        this.opCodeRegistry = opCodeRegistry;
        this.opCodeFactory = opCodeFactory;
    }

    public void registerKnownOpCodes() {
        registerNewOpCode(OpCodeIds.OP_00E0);
        registerNewOpCode(OpCodeIds.OP_00EE);
        registerNewOpCode(OpCodeIds.OP_DXYN);
        registerNewOpCode(OpCodeIds.OP_1NNN);
    }

    private void registerNewOpCode(int id) {
        opCodeRegistry.registerOpCode(id, opCodeFactory.create(id));
    }
}

