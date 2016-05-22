package com.mcleodog.Components;

import java.io.Serializable;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public interface IComponent{

    IComponentType getType();
    void update();
    byte[] export();
}
