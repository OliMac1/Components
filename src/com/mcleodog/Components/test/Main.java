package com.mcleodog.Components.test;

import com.mcleodog.Components.IBaseEntity;
import com.mcleodog.Components.exceptions.NullComponentException;

/**
 * Created by Oliver on 21/05/2016.
 */
public class Main {

    public static void main(String[] args) throws NullComponentException{
        IBaseEntity e = new TestBaseEntity();
        e.addComponent(new TestComponent());
        e.update();
    }

}
