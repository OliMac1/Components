package com.mcleodog.Components;

import com.mcleodog.Components.exceptions.EndOfFileException;
import com.mcleodog.Components.io.Loading;
import com.mcleodog.Components.io.Saving;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * Created by olivermcleod on 23/05/2016.
 */
public class ComponentIdentLoader {

    private static int i = 0;
    private static HashMap<String, Integer> idents = new HashMap<>();

    //private static String fileName = "Z:/New folder (5)/Components/idents.bin";
    private static String fileName = "/Users/olivermcleod/Desktop/Components/idents.bin";

    public static int getIdent(String name){
        if(idents.get(name) != null){
            return idents.get(name);
        }
        idents.put(name, i);
        return i++;
    }

    public static void importIdents(){
        try {
            ByteArrayInputStream b = Loading.readAllBytes(fileName);
            idents.put(Loading.getString(b),Loading.getInt(b));
            Loading.finishReading(b);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EndOfFileException e) {
        }
    }

    public static void exportIdents(){
        try {
            Path path = Saving.createFreshBinary(fileName);
            ByteArrayOutputStream b = Saving.generateByteArrayOutputStream();
            idents.forEach((k, v) -> {
                try {
                    Saving.addDataToByteArrayStream(b, Saving.stringToBytes(k));
                    Saving.addDataToByteArrayStream(b, Saving.intToBytes(v));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            Saving.writeBinaryFile(b, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
