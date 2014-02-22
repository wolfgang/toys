/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:21 PM
 */

package lib;

import lib.OpCodes.OpCode;

import java.util.concurrent.ConcurrentHashMap;

public class OpCodeRegistry {
    private OpCodeResolver opCodeResolver;
    ConcurrentHashMap<OpCodeId, OpCode> opCodesById = new ConcurrentHashMap<>();
    ConcurrentHashMap<Integer, OpCode> opCodesById2 = new ConcurrentHashMap<>();

    public OpCodeRegistry(OpCodeResolver opCodeResolver) {
        this.opCodeResolver = opCodeResolver;
    }

    public void registerOpCode(OpCodeId id, OpCode opCode) {
        opCodesById.put(id, opCode);
    }

    public void registerOpCode2(int id, OpCode opCode) {
        opCodesById2.put(id, opCode);
    }


    public OpCode getOpCode(int code) throws InvalidOpCode {
        OpCodeId id = opCodeResolver.getOpCodeId(code);
        if (id!= OpCodeId.OP_INVALID)
            return opCodesById.get(id);

        throw new InvalidOpCode(code);
    }

    public OpCode getOpCode2(int code) throws InvalidOpCode {
        int id = opCodeResolver.getOpCodeId2(code);
        if (id!= -1)
            return opCodesById2.get(id);

        throw new InvalidOpCode(code);
    }

}
