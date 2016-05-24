package com.mcleodog.Components;

import com.mcleodog.Components.exceptions.NullComponentException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public interface IBaseEntity {

    void addComponent(IComponent c) throws NullComponentException;
    IComponent removeComponent(IComponentType c);
    void update();
    void export(ByteArrayOutputStream b) throws IOException;
}
