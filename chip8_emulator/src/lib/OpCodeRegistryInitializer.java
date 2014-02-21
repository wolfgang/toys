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
        for (int id = 1; id < OpCodeIds.__END__; ++id)
            registerNewOpCode(id);
    }

    private void registerNewOpCode(int id) {
        opCodeRegistry.registerOpCode(id, opCodeFactory.create(id));
    }
}

