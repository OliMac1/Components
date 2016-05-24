package com.mcleodog.Components.io;

import javassist.bytecode.ByteArray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Oliver on 22/05/2016.
 */
public class Saving {

    public static Path createFreshBinary(String fileName) throws IOException{
        Path path = Paths.get(fileName);
        Files.write(path, new byte[0]);
        return path;
    }

    public static void writeBinaryFile(ByteArrayOutputStream b, Path p) throws IOException{
        Files.write(p, b.toByteArray(), StandardOpenOption.APPEND);
    }

    public static void addDataToByteArrayStream(ByteArrayOutputStream b, byte[] data) throws IOException {
        b.write(data);
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

    public static byte[] doubleToBytes(double d){
        ByteBuffer b = ByteBuffer.allocate(8);
        b.putDouble(d);
        return b.array();
    }

    public static byte[] shortToBytes(short s){
        ByteBuffer b = ByteBuffer.allocate(2);
        b.putShort(s);
        return b.array();
    }

    public static byte[] longToBytes(long l){
        ByteBuffer b = ByteBuffer.allocate(8);
        b.putLong(l);
        return b.array();
    }

    public static byte[] stringToBytes(String s){
        s += "\0";
        return s.getBytes();
    }

}
