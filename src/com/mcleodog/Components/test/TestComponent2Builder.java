package com.mcleodog.Components.test;

import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentBuilder;
import com.mcleodog.Components.annotations.AnnComponentBuilder;

import java.io.ByteArrayInputStream;

/**
 * Created by olivermcleod on 22/05/2016.
 */
@AnnComponentBuilder(name="TestComponent2", value=2)
public class TestComponent2Builder implements IComponentBuilder {

    @Override
    public IComponent buildNew() {
        return new TestComponent2();
    }

    @Override
    public IComponent buildFromSave(ByteArrayInputStream data) {
        return null;
    }
}
