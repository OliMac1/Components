package com.mcleodog.Components.test;

import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentBuilder;
import com.mcleodog.Components.IComponentType;
import com.mcleodog.Components.annotations.Component;
import com.mcleodog.Components.io.Loading;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;

/**
 * Created by olivermcleod on 21/05/2016.
 */
@Component(TestComponent.name)
public class TestComponent implements IComponent {

    public static final String name = "Test Component";

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

    @Component(TestComponent.name)
    public static class TestComponentBuilder implements IComponentBuilder {

        @Override
        public IComponent buildNew() {
            return new TestComponent(0);
        }

        @Override
        public IComponent buildFromSave(ByteArrayInputStream data) {
            return new TestComponent(Loading.getInt(data));
        }
    }
}
