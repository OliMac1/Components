package com.mcleodog.Components.test;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.exceptions.NullComponentException;

import java.util.HashMap;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public class TestBaseEntity implements IBaseEntity{

    private HashMap<Integer, IComponent> components;

    public TestBaseEntity(){
        components = new HashMap<Integer, IComponent>();
    }

    public void addComponent(IComponent c) throws NullComponentException{
        if(c == null){
            throw new NullComponentException();
        }
        components.put(c.getType().getPriority(), c);
    }

    public void update(){
        components.forEach((k,v) -> v.update());
    }

}
