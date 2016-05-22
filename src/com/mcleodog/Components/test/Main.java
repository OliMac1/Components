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

        String pathName = "/Users/olivermcleod/Desktop/bins.bin";
        Saving.createFreshBinary(pathName);
        Saving.writeBinaryFile(Saving.intToBytes(65565), pathName);
        Saving.writeBinaryFile(Saving.floatToBytes(435.4534f),  pathName);
        Saving.writeBinaryFile(Saving.longToBytes(98795743985937l), pathName);
        Saving.writeBinaryFile(Saving.doubleToBytes(12312.231434124), pathName);
        Saving.writeBinaryFile(Saving.shortToBytes((short)8654), pathName);
        Saving.writeBinaryFile(Saving.stringToBytes("Hello World"), pathName);
        Saving.writeBinaryFile(Saving.stringToBytes("World"), pathName);
        ByteArrayInputStream bytes = Loading.readAllBytes(pathName);
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
