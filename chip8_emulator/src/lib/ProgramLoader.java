/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 6:41 PM
 */

package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SuppressWarnings("StatementWithEmptyBody")
public class ProgramLoader {
    private Memory memory;

    public ProgramLoader(Memory memory)
    {
        this.memory = memory;
    }

    public void loadFromFile(String path) throws IOException {
        File file=new File(path);
        int size=(int)file.length();
        byte[] contents=new byte[size];
        FileInputStream in = new FileInputStream(file);
        while (in.read(contents) != contents.length) {}
        in.close();

        for (int i = 0; i<contents.length; ++i)
            memory.set(i+0x200, contents[i]);
    }
}
