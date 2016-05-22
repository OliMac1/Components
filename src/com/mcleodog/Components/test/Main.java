package com.mcleodog.Components.test;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.defaults.DefaultBaseEntity;
import com.mcleodog.Components.defaults.DefaultBaseEntityHolder;
import com.mcleodog.Components.exceptions.NullComponentException;
import com.mcleodog.Components.exceptions.NullEntityException;
import com.mcleodog.Components.io.Loading;
import com.mcleodog.Components.io.Saving;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Oliver on 21/05/2016.
 */
public class Main {

    public static void main(String[] args) throws NullComponentException, NullEntityException, IOException {
        IBaseEntityHolder e = new DefaultBaseEntityHolder();
        for(int i = 0; i < 3; i++) {
            IBaseEntity entity = new DefaultBaseEntity();
            entity.addComponent(new TestComponent2());
            entity.addComponent(new TestComponent());
            e.addEntity(entity);
        }
        e.update();
        Saving.writeBinaryFile(Saving.intToBytes(65565), "Z:/New folder (5)/bins.bin");
        Saving.writeBinaryFile(Saving.floatToBytes(435.4534f), "Z:/New folder (5)/bins.bin");
        Saving.writeBinaryFile(Saving.longToBytes(98795743985937l), "Z:/New folder (5)/bins.bin");
        Saving.writeBinaryFile(Saving.doubleToBytes(12312.231434124), "Z:/New folder (5)/bins.bin");
        Saving.writeBinaryFile(Saving.shortToBytes((short)8654), "Z:/New folder (5)/bins.bin");
        Saving.writeBinaryFile(Saving.stringToBytes("Hello"), "Z:/New folder (5)/bins.bin");
        Saving.writeBinaryFile(Saving.stringToBytes("World"), "Z:/New folder (5)/bins.bin");
        ByteArrayInputStream bytes = Loading.readAllBytes("Z:/New folder (5)/bins.bin");
        System.out.println(Loading.getInt(bytes));
        System.out.println(Loading.getFloat(bytes));
        System.out.println(Loading.getLong(bytes));
        System.out.println(Loading.getDouble(bytes));
        System.out.println(Loading.getShort(bytes));
        System.out.println(Loading.getString(bytes));
        System.out.println(Loading.getString(bytes));
        Loading.finishReading(bytes);
    }

}
