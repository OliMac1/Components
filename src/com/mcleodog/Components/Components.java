package com.mcleodog.Components;

import com.mcleodog.Components.annotations.EventHandler;
import com.mcleodog.Components.annotations.Instance;
import com.mcleodog.Components.annotations.Module;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Oliver on 23/05/2016.
 */
public class Components {

    private static HashMap<String, Object> instances = new HashMap<>();

    public static void init(){
        Reflections reflections = new Reflections();
        Set<Class<?>> moduleSet = reflections.getTypesAnnotatedWith(Module.class);
        moduleSet.forEach(module -> {
            try {
                System.out.println(module);
                Constructor constructor = module.getConstructor();
                for (Field f : module.getFields()) {
                    if (f.isAnnotationPresent(Instance.class)) {
                        f.set(null, constructor.newInstance());
                        instances.put(f.getAnnotation(Instance.class).modid(), f.get(new Object()));
                        break;
                    }
                }
                for (Method m : module.getMethods()) {
                    if (m.isAnnotationPresent(EventHandler.class)) {
                        //TODO
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
        instances.forEach((k,v) -> System.out.println(v));
    }

}
