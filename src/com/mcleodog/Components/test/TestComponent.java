package com.mcleodog.Components.test;

import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentType;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public class TestComponent implements IComponent {

    private int i;
    public TestComponent(){
        i = 0;
    }

    @Override
    public IComponentType getType() {
        return TestComponentType.TEST_COMPONENT_TYPE;
    }

    @Override
    public void update() {
        System.out.println("This is a defaults: " + i);
        i++;
    }
}
