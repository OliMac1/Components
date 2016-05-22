package com.mcleodog.Components.defaults;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentType;
import com.mcleodog.Components.exceptions.NullComponentException;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public class DefaultBaseEntity implements IBaseEntity{

    //possibly could do with a better key type. Integer can veryEasily have a clash.
    private LinkedHashMap<IComponentType, IComponent> components;
    private static KeyComparator comp = new KeyComparator();

    public DefaultBaseEntity(){
        components = new LinkedHashMap<IComponentType, IComponent>();
    }

    @Override
    public void addComponent(IComponent c) throws NullComponentException{
        if(c == null){
            throw new NullComponentException();
        }
        components.put(c.getType(), c);
        sort();
    }

    @Override
    public IComponent removeComponent(IComponentType c) {
        return components.remove(c);
    }

    @Override
    public void update(){
        components.forEach((k,v) -> v.update());
    }

    private void sort(){
        components.entrySet().stream().sorted(Map.Entry.comparingByKey(comp));
    }

    private static class KeyComparator implements Comparator<IComponentType> {

        @Override
        public int compare(IComponentType o1, IComponentType o2) {
            return o1.getPriority()-o2.getPriority();
        }
    }

}
