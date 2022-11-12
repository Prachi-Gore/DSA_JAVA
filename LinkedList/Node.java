package com.project.LinkedList;
// Generic class T : String INTEGER CHARACTER ...
public class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data) {
        this.data=data;
        this.next=null;
    }
}
