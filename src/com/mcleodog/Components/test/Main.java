package com.mcleodog.Components.test;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IBaseEntityHolder;
import com.mcleodog.Components.IComponentBuilder;
import com.mcleodog.Components.annotations.Module;
import com.mcleodog.Components.defaults.DefaultBaseEntity;
import com.mcleodog.Components.defaults.DefaultBaseEntityHolder;
import com.mcleodog.Components.exceptions.NullComponentException;
import com.mcleodog.Components.exceptions.NullEntityException;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Oliver on 21/05/2016.
 */
public class Main {

    public static void main(String[] args) throws NullComponentException, NullEntityException, IOException {

        /*Reflections reflections = new Reflections();
        HashMap<Integer, IComponentBuilder> builders = new HashMap<>();
        Set<Class<?>> buildersSet = reflections.getTypesAnnotatedWith(Module.class);
        buildersSet.forEach(c -> {
            try {
                Constructor constructor = c.getConstructor();
                Object o = constructor.newInstance();
                builders.put(c.getAnnotation(Module.class).value(),(IComponentBuilder) o);
            }catch(NoSuchMethodException e){
                System.out.println(c + " : No Main method with empty parameters.");
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });*/

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
