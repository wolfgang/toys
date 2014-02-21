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
        for (OpCodeId id : OpCodeId.values())
        {
            if (id != OpCodeId.OP_INVALID)
                registerNewOpCode(id);
        }
    }

    private void registerNewOpCode(OpCodeId id) {
        opCodeRegistry.registerOpCode(id, opCodeFactory.create(id));
    }
}

