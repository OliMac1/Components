package com.mcleodog.Components.test;

import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentBuilder;
import com.mcleodog.Components.IComponentType;
import com.mcleodog.Components.annotations.Component;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;

/**
 * Created by Oliver on 22/05/2016.
 */
@Component(TestComponent2.name)
public class TestComponent2 implements IComponent{

    public static final String name = "Test Component 2";

    @Override
    public IComponentType getType() {
        return TestComponentType.TEST_COMPONENT_TYPE_2;
    }

    @Override
    public void update() {
        System.out.println("This is a second defaults.");
    }

    @Override
    public void export(Path path) {
        //Nothing to export
    }

    @Component(TestComponent2.name)
    public static class TestComponent2Builder implements IComponentBuilder {

        @Override
        public IComponent buildNew() {
            return new TestComponent2();
        }

        @Override
        public IComponent buildFromSave(ByteArrayInputStream data) {
            return null;
        }
    }
}
