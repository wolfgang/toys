/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:21 PM
 */

package lib;

import lib.OpCodes.OpCode;

import java.util.concurrent.ConcurrentHashMap;

public class OpCodeRegistry {

    private final OpCodeResolver opCodeResolver;

    ConcurrentHashMap<Integer, OpCode> opCodesById = new ConcurrentHashMap<>();

    public OpCodeRegistry(OpCodeFactory opCodeFactory)
    {
        opCodeResolver = new OpCodeResolver();
        opCodesById.put(OpCodeIds.OP_00E0, opCodeFactory.create(OpCodeIds.OP_00E0));
        opCodesById.put(OpCodeIds.OP_DXYN, opCodeFactory.create(OpCodeIds.OP_DXYN));
        opCodesById.put(OpCodeIds.OP_1NNN, opCodeFactory.create(OpCodeIds.OP_1NNN));

    }

    public OpCodeRegistry() {
        this(new OpCodeFactory());
    }

    public OpCode getOpCode(int code) throws InvalidOpCode {
        int id = opCodeResolver.getOpCodeId(code);
        if (id!=OpCodeIds.OP_INVALID)
            return opCodesById.get(id);

        throw new InvalidOpCode(code);
    }
}
