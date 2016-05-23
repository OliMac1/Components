package com.mcleodog.Components.test;

import com.mcleodog.Components.IComponent;
import com.mcleodog.Components.IComponentBuilder;

import java.io.ByteArrayInputStream;

/**
 * Created by olivermcleod on 22/05/2016.
 */
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
