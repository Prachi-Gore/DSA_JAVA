package com.project.Recursion;

import java.util.ArrayList;

public class AllIndex {
   static int i=1;
   static int[] ans=new int[200];
    static int startIndex=1;
    public static int[] allIndexes(int[] input, int x) {
        if (startIndex == input.length)
            return new int[0]; // return an empty array
        if (input[startIndex] == x) {
            ans[i] = startIndex;
            i++;
            startIndex++;
            allIndexes(input, x);
        } else {
            startIndex++;
            allIndexes(input, x);
        }


        return ans;

    }
        public static int[] all(int[]input,int x){
            int[] ans= AllIndex.allIndexes(input,x);
            int count=0;
            if(input[0]==x) {
                for (int i = 1; i < ans.length; i++) {
                    if (ans[i] != 0)
                        count++;
                }
                int[] output = new int[count+1];
                for (int i = 1; i < ans.length; i++) {
                    if (ans[i] != 0) {
                        output[i] = ans[i];
                    } else
                        break;

                }
                return output;
            }
            else {
                for (int i = 0; i < ans.length; i++) {
                    if (ans[i] != 0)
                        count++;
                }
                int[] output = new int[count];
                for (int i = 0; i < ans.length; i++) {
                    if (ans[i] != 0) {
                        output[i-1] = ans[i];
                    }

                }
                return output;
            }
    }
    public static void main(String [] args){
        int[] a= AllIndex.all( new int[] {7,7,17,27,37,7,4},7);
        for (int i=0;i< a.length;i++) {
            System.out.print(a[i] + " ");
            //System.out.println(a.length);
        }
       // System.out.println(a.length);

            }
}
