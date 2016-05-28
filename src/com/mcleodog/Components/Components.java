package com.mcleodog.Components;

import com.mcleodog.Components.annotations.*;
import com.mcleodog.Components.exceptions.NullBuilderException;
import com.mcleodog.Components.exceptions.UnannotatedException;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Oliver on 23/05/2016.
 */
public class Components {

    private static HashMap<String, Object> instances = new HashMap<>();
    private static HashMap<String, HashMap<ModuleEventHandle, Method>> methods = new HashMap<>();
    private static HashMap<Integer, IComponentBuilder> components = new HashMap<>();

    public static void init(){
        Reflections reflections = new Reflections();
        Set<Class<?>> moduleSet = reflections.getTypesAnnotatedWith(Module.class);
        moduleSet.forEach(module -> {
            try {
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
                        HashMap<ModuleEventHandle, Method> batch = methods.get(module.getAnnotation(Module.class)
                                .modid());
                        if(batch == null){
                            batch = new HashMap<>();
                        }
                        batch.put(m.getAnnotation(EventHandler.class).value(), m);
                        methods.put(module.getAnnotation(Module.class).modid(), batch);
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
        instances.forEach((k,v) -> {
            try {
                components.get(k).get(ModuleEventHandle.INIT).invoke(v);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    public static void addComponentBuilder(IComponentBuilder builder) throws NullBuilderException, UnannotatedException {
        if(builder == null){
            throw new NullBuilderException();
        }
        Annotation a = builder.getClass().getAnnotation(Component.class);
        if(a == null){
            throw new UnannotatedException();
        }
        components.put(ComponentIdentLoader.getNextIdent(), builder);
    }

    public static IComponentBuilder getComponentBuilder(int i) throws NullBuilderException{
        IComponentBuilder builder = components.get(i);
        if(builder == null){
            throw new NullBuilderException();
        }
        return builder;
    }

}
