/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 6:27 PM
 */

package lib;

public class InvalidOpCode extends Exception {
    public InvalidOpCode(int code) {
        super(String.valueOf(code));
    }
}
