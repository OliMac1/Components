package com.mcleodog.Components.test;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.defaults.DefaultBaseEntity;
import com.mcleodog.Components.defaults.DefaultBaseEntityHolder;
import com.mcleodog.Components.exceptions.NullComponentException;
import com.mcleodog.Components.exceptions.NullEntityException;
import com.mcleodog.Components.io.Loading;
import com.mcleodog.Components.io.Saving;
import com.sun.deploy.config.Platform;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Oliver on 21/05/2016.
 */
public class Main {

    public static void main(String[] args) throws NullComponentException, NullEntityException, IOException {
        IBaseEntityHolder e = new DefaultBaseEntityHolder();
        for(int i = 0; i < 5; i++) {
            IBaseEntity entity = new DefaultBaseEntity();
            entity.addComponent(new TestComponent2());
            entity.addComponent(new TestComponent());
            e.addEntity(entity);
        }
        e.update();

        e.export();

    }

}
