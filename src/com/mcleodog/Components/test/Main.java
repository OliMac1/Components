package com.mcleodog.Components.test;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.annotations.Instance;
import com.mcleodog.Components.annotations.Module;
import com.mcleodog.Components.defaults.DefaultBaseEntity;
import com.mcleodog.Components.defaults.DefaultBaseEntityHolder;
import com.mcleodog.Components.exceptions.NullComponentException;
import com.mcleodog.Components.exceptions.NullEntityException;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Oliver on 21/05/2016.
 */
public class Main {

    public static void main(String[] args) throws NullComponentException, NullEntityException, IOException {

        Reflections reflections = new Reflections();
        Set<Class<?>> moduleSet = reflections.getTypesAnnotatedWith(Module.class);
        Set<Field> instanceSet = reflections.getFieldsAnnotatedWith(Instance.class);
        moduleSet.forEach(module -> {

        });

        IBaseEntityHolder e = new DefaultBaseEntityHolder();
        for(int i = 0; i < 5; i++) {
            IBaseEntity entity = new DefaultBaseEntity();
            /*entity.addComponent(builders.get(2).buildNew());
            entity.addComponent(builders.get(1).buildNew());*/
            e.addEntity(entity);
        }
        e.update();

        e.export();
    }

}
