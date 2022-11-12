package com.project.Stack;

import java.util.Stack;

public class Collection {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 5; i=i + 2){
            s.push(i);
        }
        while (!s.isEmpty()) {
            System.out.println(s.peek()); // to get top elt
            s.pop();
        }
    }
}