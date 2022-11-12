package com.project.Test1;

public class Split {
    public static void main(String[] args){
        System.out.println(splitArray(new int[]{1,1,1}));
        System.out.println(splitArray(new int[]{1,1}));
        System.out.println(splitArray(new int[]{1,2,3,4}));
    }
    public static boolean splitArray(int input[]) {

        return splitArray(input,0,0,0);
    }

    public static boolean splitArray(int arr[], int si, int lsum, int rsum)
    {
        //lsum for sum of numbers divisible by 5 and rsum for sum of numbers divisible by 3

        if (si == arr.length)
        {
            return lsum == rsum;
        }

        if (arr[si] % 5 == 0)
        {
            lsum += arr[si];
        }
        else if (arr[si] % 3 == 0)
        {
            rsum += arr[si];
        }
        else
        {
            return splitArray(arr,si+1, lsum+arr[si], rsum)  || splitArray(arr,si+1,lsum,rsum+arr[si]);
        }

        return splitArray(arr,si+1,lsum,rsum);
    }
}


