package com.mcleodog.Components;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public interface IComponent{

    IComponentType getType();
    void update();
    void export(ByteArrayOutputStream b) throws IOException;
}
