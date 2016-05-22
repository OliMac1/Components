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

    public static long getLong(ByteArrayInputStream data){
        byte[] i = new byte[8];
        data.read(i, 0, 8);
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getLong();
    }

    public static double getDouble(ByteArrayInputStream data){
        byte[] i = new byte[8];
        data.read(i, 0, 8);
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getDouble();
    }

    public static short getShort(ByteArrayInputStream data){
        byte[] i = new byte[2];
        data.read(i, 0, 2);
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getShort();
    }

    public static void finishReading(ByteArrayInputStream reader) throws IOException {
        reader.close();
    }
}
