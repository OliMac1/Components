package com.mcleodog.Components;

import com.mcleodog.Components.exceptions.NullComponentException;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public interface IBaseEntity {

    void addComponent(IComponent c) throws NullComponentException;
    IComponent removeComponent(IComponentType c);
    void update();
    void export(Path path) throws IOException;
}
