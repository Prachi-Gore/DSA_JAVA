package com.project.Recursion;

public class Sum {
    public static int sum(int[] input){
        int n=input.length;
        int [] small=new int[n-1];

        for (int i=0;i<small.length;i++){
            small[i]=input[i+1];
        }
        if(input.length==1)
            return input[0];
        return input[0]+sum( small);
    }
    public static void main(String[] args){
        int arr[]={5,7,0,-2};
        System.out.println(Sum.sum(arr));
    }
}
