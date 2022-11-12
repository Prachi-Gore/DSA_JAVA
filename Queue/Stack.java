package com.project.Queue;

import java.util.LinkedList;
import java.util.Queue;

// Stack using 2 Queues
public class Stack {
   private Queue q1;
  private   Queue q2;
   private int size;

    public Stack(){
        Queue q1=new LinkedList();
        Queue q2=new LinkedList();
        size=0;
    }
    public int getSize() {
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        return size==0;
    }

    public void push(int element) {
        //Implement the push(element) function
        q1.add(element);
        size++;
    }

    public int pop() {
        //Implement the pop() function
        if (q1.isEmpty())
            return -1;
        while(q1.size()!=1)
               q2.add(q1.remove());
        int top=(int)q1.remove();
        while (!q2.isEmpty())
              q1.add(q2.remove());
        size--;
        return top;
    }

    public int top() {
        //Implement the top() function
        if (q1.isEmpty())
            return -1;
        while(q1.size()!=1)
            q2.add(q1.remove());
        int top=(int)q1.remove();
        while (!q2.isEmpty())
            q1.add(q2.remove());
        q1.add(top);
        return top;
    }
}
