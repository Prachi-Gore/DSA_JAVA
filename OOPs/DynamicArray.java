package com.project;

public class DynamicArray {
    int data[];
    int nextIndex;

    DynamicArray(){
        data=new int[5];
        nextIndex=0;
    }
   public int size(){
        return nextIndex;
    }
   public void add(int element){
        if (nextIndex==data.length)
            restructure();
        data[nextIndex]=element;
        nextIndex++;
    }
  public void set(int index,int element){
        if (index<=nextIndex) {
            data[index] = element;
        }
  }
  public   int get(int index){
        if (index<nextIndex)
             return data[index];
        return -1;
    }
   public boolean isEmpty(){
        if (size()==0)
          return true;
        else
            return false;
    }
   public int lastElement(){ // remove and get last elt
        if (size()==0)
            return -1;
        int value=data[nextIndex-1];
        data[nextIndex-1]=0;
        nextIndex--;
        return  value;
    }
   private void restructure(){
        int temp[]=data;
        data=new int[2*size()];
        for (int i=0;i<size();i++)
            data[i]=temp[i];
    }
}
