package com.mcleodog.Components.test;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.exceptions.NullEntityException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public class TestBaseEntityHolder implements IBaseEntityHolder {

    List<IBaseEntity> entities;

    public TestBaseEntityHolder(){
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
}
