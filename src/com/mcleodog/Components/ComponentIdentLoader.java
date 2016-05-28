package com.mcleodog.Components;

import java.util.HashMap;

/**
 * Created by olivermcleod on 23/05/2016.
 */
//TODO sort out ident handling.
public class ComponentIdentLoader {

    private static int i = 0;
    private static HashMap<String, Integer> idents = new HashMap<>();

    public static int getIdent(String name){

        return i++;
    }

}
