package com.project;

public class RotateArray {

    public static void rotate(int[] arr, int d) {
        //Your code goes here
        if (d>0)
        {
            d=d%(arr.length);
            int[] temp=new int[d];
            for (int i=0;i<d;i++)
            {
                temp[i]=arr[i];
                //System.out.print(temp[i]+" ");
            }

            //System.out.println();

            for (int i=0,j=0;i<arr.length&&j<d;i++)
            {
                if (i>=(arr.length-d))
                {
                    arr[i]=temp[j];
                    j++;
                }
                else
                {
                    arr[i]=arr[(i+d)%arr.length];
                }
            }
        }

    }
    public static int arrayRotateCheck(int[] arr){
        //arr is sorted
        // 3 4 5 1 2 // idx=3
        int out = 0;

        for(int i = 0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return i+1;
            }
        }
        return out;
    }

}


