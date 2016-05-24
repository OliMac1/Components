package com.mcleodog.Components.test;

import com.mcleodog.Components.Components;
import com.mcleodog.Components.annotations.EventHandler;
import com.mcleodog.Components.annotations.Instance;
import com.mcleodog.Components.annotations.Module;
import com.mcleodog.Components.annotations.ModuleEventHandle;
import com.mcleodog.Components.exceptions.NullBuilderException;
import com.mcleodog.Components.exceptions.UnannotatedException;

/**
 * Created by olivermcleod on 23/05/2016.
 */
@Module(modid=TestModule.MODID, name = TestModule.MOD_NAME, version = TestModule.VERSION)
public class TestModule {

    public static final String MODID = "test";
    public static final String MOD_NAME = "Test";
    public static final String VERSION = "0.0.0";

    @Instance(modid = TestModule.MODID)
    public static TestModule instance;

    @EventHandler(ModuleEventHandle.INIT)
    public void initialization(){
        try {
            Components.addComponentBuilder(new TestComponent.TestComponentBuilder());
            Components.addComponentBuilder(new TestComponent2.TestComponent2Builder());
        } catch (NullBuilderException e) {
            e.printStackTrace();
        } catch (UnannotatedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Test Module";
    }
}
