package com.mcleodog.Components.test;

import com.mcleodog.Components.IComponentType;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public enum TestComponentType implements IComponentType{

    TEST_COMPONENT_TYPE(1);

    private int priority;

    private TestComponentType(int i){
        priority = i;
    }

    @Override
    public int getPriority() {
        return priority;
    }
}
