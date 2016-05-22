package com.mcleodog.Components;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public interface IComponent{

    IComponentType getType();
    void update();
    void export(Path path) throws IOException;
}
