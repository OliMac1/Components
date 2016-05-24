package com.mcleodog.Components;

/**
 * Created by olivermcleod on 23/05/2016.
 */
//TODO sort out ident handling.
public class ComponentIdentLoader {

    private static int i = 0;

    public static int getNextIdent(){
        return i++;
    }

}
