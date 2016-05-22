package com.mcleodog.Components.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.*;

/**
 * Created by Oliver on 22/05/2016.
 */
public class Saving {

    public static void writeBinaryFile(byte[] data, String fileName) throws IOException{
        Path path = Paths.get(fileName);
        while(true) {
            try {
                Files.write(path, data, StandardOpenOption.APPEND);
                return;
            } catch (NoSuchFileException e) {
                Files.createFile(path);

            }
        }
    }

    public static byte[] intToBytes(int i){
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putInt(i);
        return b.array();
    }

    public static byte[] floatToBytes(float f){
        ByteBuffer b = ByteBuffer.allocate(4);
        b.putFloat(f);
        return b.array();
    }

}
