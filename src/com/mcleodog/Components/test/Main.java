package com.mcleodog.Components.test;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.defaults.DefaultBaseEntity;
import com.mcleodog.Components.defaults.DefaultBaseEntityHolder;
import com.mcleodog.Components.exceptions.NullComponentException;
import com.mcleodog.Components.exceptions.NullEntityException;

/**
 * Created by Oliver on 21/05/2016.
 */
public class Main {

    public static void main(String[] args) throws NullComponentException, NullEntityException {
        IBaseEntityHolder e = new DefaultBaseEntityHolder();
        for(int i = 0; i < 3; i++) {
            IBaseEntity entity = new DefaultBaseEntity();
            entity.addComponent(new TestComponent2());
            entity.addComponent(new TestComponent());
            e.addEntity(entity);
        }
        e.update();
    }

}
