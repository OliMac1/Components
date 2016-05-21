package com.mcleodog.Components;

import java.util.HashMap;

/**
 * Created by Oliver on 21/05/2016.
 */
public class Main {

    public static void main(String[] args){
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1,"Wow");
        map.put(12,"god");
        map.put(2,"you");
        map.forEach((k,v) -> System.out.println(v));
        System.out.println("End");
    }


}
