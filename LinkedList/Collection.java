package com.project.LinkedList;

import java.util.LinkedList;

public class Collection {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>(); // Doubly LL
        System.out.println(list.isEmpty());
        list.add(10);// add elt at the last
        list.addLast(3);// add elt at the last
        list.addFirst(12);
        list.set(2, 15);
        list.add(3, 7);
        list.add( 17);
        System.out.println(list.isEmpty());
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        for (int i=0;i<list.size();i++)
            System.out.print(list.get(i)+" ");
    }
}