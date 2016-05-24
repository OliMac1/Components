package com.mcleodog.Components.io;

import com.mcleodog.Components.exceptions.EndOfFileException;

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

    public static int getInt(ByteArrayInputStream data) throws EndOfFileException{
        byte[] i = new byte[4];
        if(data.read(i, 0, 4) < 1){
            throw new EndOfFileException();
        }
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getInt();
    }

    public static float getFloat(ByteArrayInputStream data) throws EndOfFileException{
        byte[] i = new byte[4];
        if(data.read(i, 0, 4) < 1){
            throw new EndOfFileException();
        }
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getFloat();
    }

    public static long getLong(ByteArrayInputStream data) throws EndOfFileException{
        byte[] i = new byte[8];
        if(data.read(i, 0, 8) < 1){
            throw new EndOfFileException();
        }
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getLong();
    }

    public static double getDouble(ByteArrayInputStream data) throws EndOfFileException{
        byte[] i = new byte[8];
        if(data.read(i, 0, 8) < 1){
            throw new EndOfFileException();
        }
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getDouble();
    }

    public static short getShort(ByteArrayInputStream data) throws EndOfFileException{
        byte[] i = new byte[2];
        if(data.read(i, 0, 2) < 1){
            throw new EndOfFileException();
        }
        ByteBuffer b = ByteBuffer.wrap(i);
        return b.getShort();
    }

    public static String getString(ByteArrayInputStream data) throws EndOfFileException{
        data.mark(0);
        byte[] b = new byte[1];
        if(data.read(b, 0, 1) < 1){
            throw new EndOfFileException();
        }
        int i = 0;
        while(b[0] != 0x00){
            if(data.read(b, 0, 1) < 1){
                throw new EndOfFileException();
            }
            i++;
        }
        data.reset();
        byte[] array = new byte[i];
        if(data.read(array, 0, i) < 1){
            throw new EndOfFileException();
        }
        if(data.read(b, 0, 1) < 1){
            throw new EndOfFileException();
        }
        return new String(array);
    }

    public static void finishReading(ByteArrayInputStream reader) throws IOException {
        reader.close();
    }
}
