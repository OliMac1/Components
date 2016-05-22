package com.mcleodog.Components.test;

import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentBuilder;
import com.mcleodog.Components.annotations.AnnComponentBuilder;
import com.mcleodog.Components.io.Loading;

import java.io.ByteArrayInputStream;

/**
 * Created by olivermcleod on 22/05/2016.
 */
@AnnComponentBuilder(name = "TestComponent", value=1)
public class TestComponentBuilder implements IComponentBuilder{

    @Override
    public IComponent buildNew() {
        return new TestComponent(0);
    }

    @Override
    public IComponent buildFromSave(ByteArrayInputStream data) {
        return new TestComponent(Loading.getInt(data));
    }
}
