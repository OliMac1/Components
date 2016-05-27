package com.mcleodog.Components.defaults;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentType;
import com.mcleodog.Components.exceptions.NullComponentException;
import com.mcleodog.Components.io.Saving;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public class DefaultBaseEntity implements IBaseEntity {

    private static KeyComparator comp = new KeyComparator();
    private PriorityQueue<IComponent> components;

    public DefaultBaseEntity() {
        components = new PriorityQueue<>(comp);
    }

    @Override
    public void addComponent(IComponent c) throws NullComponentException {
        if (c == null) {
            throw new NullComponentException();
        }
        removeComponent(c.getType());
        components.add(c);
    }

    @Override
    public IComponent removeComponent(IComponentType c) {
        IComponent[] removal = {null};
        components.forEach(e -> {
            if(e.getType() == c){
                components.remove(e);
                removal[0] = e;
            }
        });
        return removal[0];
    }

    @Override
    public void update() {
        components.forEach(v -> v.update());
    }

    @Override
    public void export(ByteArrayOutputStream b) throws IOException{
        Saving.addDataToByteArrayStream(b, Saving.intToBytes(components.size()));
        components.forEach(v -> {
            try {
                //TODO export Key in a usable format. Only doable after performance fixed
                v.export(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static class KeyComparator implements Comparator<IComponent> {
        @Override
        public int compare(IComponent o1, IComponent o2) {
            return o2.getType().getPriority() - o1.getType().getPriority();
        }
    }

}
