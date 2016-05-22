package com.mcleodog.Components;

import java.io.ByteArrayInputStream;

/**
 * Created by Oliver on 22/05/2016.
 */

public interface IComponentBuilder {

    IComponent buildNew();
    IComponent buildFromSave(ByteArrayInputStream data);
}
