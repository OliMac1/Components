package com.mcleodog.Components;

import com.mcleodog.Components.exceptions.NullEntityException;
import com.mcleodog.Components.test.TestBaseEntity;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public interface IBaseEntityHolder {

    void addEntity(IBaseEntity entity) throws NullEntityException;
    boolean removeEntity(IBaseEntity entity);
    void update();
}
