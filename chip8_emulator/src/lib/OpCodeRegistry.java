/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:21 PM
 */

package lib;

import lib.OpCodes.OpCode;
import lib.OpCodes.OpCode00E0;
import lib.OpCodes.OpCode1NNN;
import lib.OpCodes.OpCodeDXYN;

import java.util.concurrent.ConcurrentHashMap;

public class OpCodeRegistry {

    private final OpCodeResolver opCodeResolver;

    ConcurrentHashMap<Integer, OpCode> opCodesById = new ConcurrentHashMap<>();

    public OpCodeRegistry() {
        opCodesById.put(OpCodeIds.OP_00E0, new OpCode00E0());
        opCodesById.put(OpCodeIds.OP_DXYN, new OpCodeDXYN());
        opCodesById.put(OpCodeIds.OP_1NNN, new OpCode1NNN());
        opCodeResolver = new OpCodeResolver();
    }

    public OpCode getOpCode(int code) throws InvalidOpCode {
        int id = opCodeResolver.getOpCodeId(code);
        if (id!=OpCodeIds.OP_INVALID)
            return opCodesById.get(id);

        throw new InvalidOpCode(code);
    }
}
