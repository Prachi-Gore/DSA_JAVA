package com.project.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Collection {
    // queue is interface some methods are undefined so we can't create its object thats why creating ll object
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        System.out.println(q.isEmpty());
        q.add(5);
        q.add(51);
        q.add(15);
        System.out.println( q.element());
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q.remove());
    }
}
