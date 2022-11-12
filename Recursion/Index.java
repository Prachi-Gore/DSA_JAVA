package com.project.Recursion;

public class Index {
    // return the index at which x occurs first time
    public static int firstIndex(int[] input,int x,int startIndex){
        if(startIndex== input.length) // here input arr is fixed ,we are varying startIndex
            return -1;
        if (input[startIndex] == x)
                return startIndex;
        else
            return firstIndex(input,x,startIndex+1);
    }
    public static int firstIndex(int[] input,int x){ // method overloading
        return Index.firstIndex(input,x,0);
    }
    public static void main(String [] args){
       int ans= Index.firstIndex( new int[] {5,8,4,8,1},5);
        System.out.println(ans);
    }
}
/*
    static int startIndex;
    public static int firstIndex(int input[], int x) {
        if(startIndex==input.length)
            return -1;
        if(input[startIndex]==x)
            return startIndex;
        else{
            startIndex++;
            return firstIndex(input,x);
        }


    }*/

