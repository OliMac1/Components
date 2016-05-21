package com.mcleodog.Components;

import com.mcleodog.Components.exceptions.NullEntityException;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public interface IBaseEntityHolder {

    void addEntity(BaseEntity entity) throws NullEntityException;
    void update();
}
