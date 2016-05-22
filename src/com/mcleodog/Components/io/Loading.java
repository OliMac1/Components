package com.mcleodog.Components.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Oliver on 22/05/2016.
 */
public class Loading {

    public static ByteArrayInputStream readAllBytes(String fileName) throws IOException{
        Path path = Paths.get(fileName);
        byte[] data = Files.readAllBytes(path);
        return new ByteArrayInputStream(data);
    }

    public static int getInt(ByteArrayInputStream data){
        byte[] i = new byte[4];
        data.read(i, 0, 4);
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getInt();
    }

    public static float getFloat(ByteArrayInputStream data){
        byte[] i = new byte[4];
        data.read(i, 0, 4);
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getFloat();
    }

    public static void finishReading(ByteArrayInputStream reader) throws IOException {
        reader.close();
    }
}
