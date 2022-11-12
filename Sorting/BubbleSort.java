package com.project;

public class BubbleSort {
    public static void main(String[] args) {
        asscending(new int[]{7,5,9,11,2,7});
        System.out.println();
        descending(new int[]{7,5,9,11,2,7});

    }

     static void asscending(int[] arr) {
        //int[] arr={7,5,9,11,2};//array of 5 elts
        // we will only sort 4 elts remaining one will get placed correctly(automatically)
        for (int i = 0; i < arr.length-1; i++) { //i=0 1 2 3
            for (int j = 0; j < arr.length - 1 - i; j++) {// we will not touch sorted elts //there will be i sorted elts at i th iteration
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            // after executing inner loop 1st time max elt will get placed at last position
            // after executing inner loop 2nd time 2nd max elt will get placed at 2nd last position
            }
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    static void descending(int[] arr) {
        //int[] arr={7,5,9,11,2};//array of 5 elts
        // we will only sort 4 elts remaining one will get placed correctly(automatically)
        for (int i = 0; i < arr.length - 1; i++) { //i=0 1 2 3
            for (int j = 0; j < arr.length - 1 - i; j++) {// we will not touch sorted elts //there will be i sorted elts at i th iteration
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
/*time complexity
  0 to n-2=n-1 outer loop
  0 to n-2-i=n-1-i inner loop
  n-1+n-2+...+0=(n-1)n/2
 O(n^2)*/