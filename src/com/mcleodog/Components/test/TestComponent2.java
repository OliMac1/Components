package com.mcleodog.Components.test;

import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentType;

/**
 * Created by Oliver on 22/05/2016.
 */
public class TestComponent2 implements IComponent{
    @Override
    public IComponentType getType() {
        return TestComponentType.TEST_COMPONENT_TYPE_2;
    }

    @Override
    public void update() {
        System.out.println("This is a second test.");
    }
}
