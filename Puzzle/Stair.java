package com.project.Puzzle;

public class Stair {
    public static int staircase(int n){
        if (n==0|n==1) // keep ourselves where we are,1
            return 1;
        if (n==2) // 1 1,2
            return 2;
        if (n==3) // 1 1 1,1 2,2 1,3
            return 4;
        return staircase(n-1)+staircase(n-2)+staircase(n-3);

    }
    public static void main(String[] args){
        System.out.println(staircase(4));

    }
}
