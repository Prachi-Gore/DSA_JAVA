package com.project.Hash;

import java.util.HashMap;
import java.util.Set;

public class Inbuilt {
    public static void main(String[] args) {
        // create hashmap
        HashMap<String, Integer> map = new HashMap<>();

        //insert keys are unique
        map.put("Prachi", 2103);
        map.put("Kalyani", 2107);
        map.put("Prachi", 2113);// it will update earlier one
        map.put("Chetana", 2115);

        //size
        System.out.println(map.size());

        //check presence
        if (map.containsKey("Kalyani"))
            System.out.println("Kalyani is present");
        if (map.containsValue(2113))
            System.out.println("roll no. 2113 is there");

        //get value
        int v = 0;
        v = map.get("Prachi");
        System.out.println(v);

        //remove
        System.out.println(map.remove("Kalyani"));// will get corresponding value

        //keyset
        Set keys = map.keySet();

        //iterate
        for (Object name : keys)//{
            System.out.println(name + " "+map.get(name));

    }



    }

