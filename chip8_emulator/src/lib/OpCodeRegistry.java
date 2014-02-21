/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:21 PM
 */

package lib;

import lib.OpCodes.OpCode;

import java.util.concurrent.ConcurrentHashMap;

public class OpCodeRegistry {
    private OpCodeResolver opCodeResolver;
    ConcurrentHashMap<Integer, OpCode> opCodesById = new ConcurrentHashMap<>();

    public OpCodeRegistry() {
        this(new OpCodeFactory());
    }

    public OpCodeRegistry(OpCodeResolver opCodeResolver) {

        this.opCodeResolver = opCodeResolver;
    }

    public OpCodeRegistry(OpCodeFactory opCodeFactory)
    {
        opCodeResolver = new OpCodeResolver();
        opCodesById.put(OpCodeIds.OP_00E0, opCodeFactory.create(OpCodeIds.OP_00E0));
        opCodesById.put(OpCodeIds.OP_DXYN, opCodeFactory.create(OpCodeIds.OP_DXYN));
        opCodesById.put(OpCodeIds.OP_1NNN, opCodeFactory.create(OpCodeIds.OP_1NNN));
        opCodesById.put(OpCodeIds.OP_00EE, opCodeFactory.create(OpCodeIds.OP_00EE));
    }

    public void registerOpCode(int id, OpCode opCode) {
        opCodesById.put(id, opCode);
    }

    public OpCode getOpCode(int code) throws InvalidOpCode {
        int id = opCodeResolver.getOpCodeId(code);
        if (id!=OpCodeIds.OP_INVALID)
            return opCodesById.get(id);

        throw new InvalidOpCode(code);
    }
}
