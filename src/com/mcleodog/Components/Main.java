package com.mcleodog.Components;

import com.mcleodog.Components.exceptions.NullComponentException;
import com.mcleodog.Components.test.TestComponent;

import java.util.HashMap;

/**
 * Created by Oliver on 21/05/2016.
 */
public class Main {

    public static void main(String[] args) throws NullComponentException{
        BaseEntity e = new BaseEntity();
        e.addComponent(new TestComponent());
        e.update();
    }


}
