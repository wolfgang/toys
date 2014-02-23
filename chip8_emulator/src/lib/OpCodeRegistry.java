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

    public OpCodeRegistry(OpCodeResolver opCodeResolver) {
        this.opCodeResolver = opCodeResolver;
    }

    public void registerOpCode(int id, OpCode opCode) {
        opCodesById.put(id, opCode);
    }


    public OpCode getOpCode(int code) throws InvalidOpCode {
        int id = opCodeResolver.getOpCodeId(code);
        if (id != -1)
            return opCodesById.get(id);

        throw new InvalidOpCode(code);
    }

}
