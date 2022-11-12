package com.project.Recursion;

public class LastIndex {
    static int a;
    static int startIndex;
    public static int lastIndex(int input[], int x) {
        if(startIndex==input.length)
            return -1;

        if (input[startIndex] == x) {
                a=startIndex;
                startIndex++;
               lastIndex(input, x);
        } else {
                startIndex++;
               return lastIndex(input, x);
        }

        return a;
    }
    public static void main(String [] args){
        int ans= LastIndex.lastIndex( new int[] {1,8,7,7,7,1,7},76);
        System.out.println(ans);
    }
}
