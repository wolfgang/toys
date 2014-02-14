/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 1/30/14 at 9:14 AM
 */

package main;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DoubleBufferedWindow mainWindow = new DoubleBufferedWindow("Chip8 Emulator", 10, 10, 1024, 768);
        //noinspection InfiniteLoopStatement
        while(true)
        {
            mainWindow.clear(Color.blue);
            mainWindow.showBuffer();
            Thread.sleep(1);
        }
    }
}
