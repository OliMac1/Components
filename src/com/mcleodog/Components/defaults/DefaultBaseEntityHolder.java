package com.mcleodog.Components.defaults;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.exceptions.NullEntityException;
import com.mcleodog.Components.io.Saving;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public class DefaultBaseEntityHolder implements IBaseEntityHolder {

    List<IBaseEntity> entities;

    public DefaultBaseEntityHolder(){
        entities = new ArrayList<IBaseEntity>();
    }

    @Override
    public void addEntity(IBaseEntity entity) throws NullEntityException{
        if(entity == null){
            throw new NullEntityException();
        }
        entities.add(entity);
    }

    @Override
    public boolean removeEntity(IBaseEntity entity){
        return entities.remove(entity);
    }

    @Override
    public void update() {
        entities.forEach(entity -> entity.update());
    }

    @Override
    public void export() {
        //String fileName = "Z:/New folder (5)/Components/entities.bin";
        String fileName = "/Users/olivermcleod/Desktop/Components/entities.bin";
        try {
            Path path = Saving.createFreshBinary(fileName);
            ByteArrayOutputStream byteArrayOutputStream = Saving.generateByteArrayOutputStream();
            Saving.addDataToByteArrayStream(byteArrayOutputStream, Saving.intToBytes(entities.size()));
            entities.forEach(e -> {
                try {
                    e.export(byteArrayOutputStream);
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            });
            Saving.writeBinaryFile(byteArrayOutputStream, path);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
