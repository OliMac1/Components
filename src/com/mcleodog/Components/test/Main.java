package com.mcleodog.Components.test;

import com.mcleodog.Components.Components;
import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.defaults.DefaultBaseEntity;
import com.mcleodog.Components.defaults.DefaultBaseEntityHolder;
import com.mcleodog.Components.exceptions.EndOfFileException;
import com.mcleodog.Components.exceptions.NullBuilderException;
import com.mcleodog.Components.exceptions.NullComponentException;
import com.mcleodog.Components.exceptions.NullEntityException;

import java.io.IOException;

/**
 * Created by Oliver on 21/05/2016.
 */
public class Main {

    public static void main(String[] args) throws NullComponentException, NullEntityException, IOException, EndOfFileException {

        Components.init();

        System.out.println("Start build");
        long time = System.nanoTime();
        IBaseEntityHolder e = new DefaultBaseEntityHolder();
        for(int i = 0; i < 700000; i++) {
            IBaseEntity entity = new DefaultBaseEntity();
            try {
                entity.addComponent(Components.getComponentBuilder(0).buildNew());
                entity.addComponent(Components.getComponentBuilder(1).buildNew());
            } catch (NullBuilderException e1) {
                e1.printStackTrace();
            }
            e.addEntity(entity);
        }
        System.out.println("Finish Build");
        System.out.println(System.nanoTime() - time);

        e.update();
        e.update();
        e.update();

        System.out.println("Start export");
        e.export();
        System.out.println("Export Complete");
    }
}
