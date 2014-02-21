/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 11:07 AM
 */

package lib;

import lib.OpCodes.OpCode;
import lib.OpCodes.OpCode00E0;
import lib.OpCodes.OpCode1NNN;
import lib.OpCodes.OpCodeDXYN;

public class OpCodeFactory {
    public OpCode create(int opCodeId) {
        switch (opCodeId) {
            case OpCodeIds.OP_00E0:
                return new OpCode00E0();
            case OpCodeIds.OP_DXYN:
                return new OpCodeDXYN();
            case OpCodeIds.OP_1NNN:
                return new OpCode1NNN();
            default:
                throw new InvalidOpCodeId();
        }
    }
}
