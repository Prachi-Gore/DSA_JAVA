package com.project.Queue;

import com.project.LinkedList.Node;

public class QueueUsingLL<T> {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
    private Node front;
    private Node rear;
    private int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void enqueue(int data) {
     Node newNode=new Node(data);
     if (front==null)
         front=newNode;
     else
         rear.next=newNode;
     rear=newNode;
     size++;
    }
    public int dequeue() {
        if (size==0)
            // throw an empty queue error
            return -1;
        if (size==1)
            rear=null;
        int temp= (int) front.data;
        front=front.next;
        size--;
        return temp;

    }


    public int front() {
        if(front==null)
            return -1;
        return front.data;
    }
}
