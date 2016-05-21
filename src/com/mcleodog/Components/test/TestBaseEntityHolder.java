package com.mcleodog.Components.test;

import com.mcleodog.Components.BaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.exceptions.NullEntityException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public class TestBaseEntityHolder implements IBaseEntityHolder {

    List<BaseEntity> entities;

    public TestBaseEntityHolder(){
        entities = new ArrayList<BaseEntity>();
    }

    @Override
    public void addEntity(BaseEntity entity) throws NullEntityException{
        if(entity == null){
            throw new NullEntityException();
        }
        entities.add(entity);
    }

    @Override
    public void update() {
        entities.forEach(entity -> entity.update());
    }
}
