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

public class OpCodeFactory {

    private static final Integer OP_00E0 = 0;
    private static final Integer OP_DXYN = 1;
    private static final Integer OP_1NNN = 2;

    ConcurrentHashMap<Integer, OpCode> opCodesById = new ConcurrentHashMap<>();
    public OpCodeFactory() {
        opCodesById.put(OP_00E0, new OpCode00E0());
        opCodesById.put(OP_DXYN, new OpCodeDXYN());
        opCodesById.put(OP_1NNN, new OpCode1NNN());
    }

    public OpCode getOpCode(int code) throws InvalidOpCode {
        if ((code & 0xD000) == 0xD000)
            return opCodesById.get(OP_DXYN);

        if ((code & 0x1000) == 0x1000)
            return opCodesById.get(OP_1NNN);

        if (code == 0x00E0)
            return opCodesById.get(OP_00E0);

        throw new InvalidOpCode(code);
    }
}
