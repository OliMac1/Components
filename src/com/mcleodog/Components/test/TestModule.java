package com.mcleodog.Components.test;

import com.mcleodog.Components.annotations.Instance;
import com.mcleodog.Components.annotations.Module;

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

    @Override
    public String toString() {
        return "Test Module";
    }
}
