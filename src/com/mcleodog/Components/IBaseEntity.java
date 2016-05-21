package com.mcleodog.Components;

import com.mcleodog.Components.exceptions.NullComponentException;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public interface IBaseEntity {

    void addComponent(IComponent c) throws NullComponentException;

    void update();
}
