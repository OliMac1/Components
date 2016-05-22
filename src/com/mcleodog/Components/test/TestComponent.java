package com.mcleodog.Components.test;

import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentType;

import java.nio.file.Path;

/**
 * Created by olivermcleod on 21/05/2016.
 */
public class TestComponent implements IComponent {

    private int i;
    public TestComponent(int i){
        this.i = i;
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

    @Override
    public void export(Path path) {
        //TODO
    }
}
