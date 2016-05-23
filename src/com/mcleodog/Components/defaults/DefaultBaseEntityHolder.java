package com.mcleodog.Components.defaults;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.exceptions.NullEntityException;
import com.mcleodog.Components.io.Saving;

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
            Saving.writeBinaryFile(Saving.intToBytes(entities.size()), path);
            entities.forEach(e -> {
                try {
                    e.export(path);
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            });
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
