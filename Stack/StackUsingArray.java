package com.project.Stack;

public class StackUsingArray {
    private int data[];
    private int top;// is index of topmost elt of stack
    public StackUsingArray(int capacity){ // capacity:maximum number of elts can store
        data=new int[capacity];
        top=-1; // intially stack is empty
    }
     public boolean isEmpty(){
        return (top==-1);
     }
    public int size(){
        return top+1;
    }
    public int top() throws StackEmptyException {
        if (isEmpty()){
            StackEmptyException e=new StackEmptyException();
            throw e;
        }
        return data[top];

    }
    public void push(int elt){ //throws StackFullException
      /*  if (data.length==size()){
            StackFullException e=new StackFullException();
            throw e;
        }*/
       // System.out.println(top++);
        data[top+1]=elt; // dont give top++
        top++;
    }
   public int pop() { //throws StackEmptyException
     /*  if (isEmpty()){
           StackEmptyException e=new StackEmptyException();
           throw e;
       }*/
        int temp=data[top];
        top=top-1;
        return temp;

    }
    private void doubleCapacity(){ // use this method and dont write that exception part
        int temp[]=data;
        data=new int[2* temp.length];
        for (int i=0;i<data.length;i++){
            data[i]=temp[i];
        }
    }
    public static void main(String[] args){
        StackUsingArray s=new StackUsingArray(10);
        //s.data we cant access data since its private
        System.out.println(s.size());
        s.push(5);
        s.push(10);
        s.push(20);
        s.push(7);
        System.out.println(s.isEmpty());

        System.out.println(s.pop());
    }
}

