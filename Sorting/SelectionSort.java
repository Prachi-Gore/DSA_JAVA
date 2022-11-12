package com.project;

public class SelectionSort {

    public static void main(String[] args) {
        asscending(new int[]{7,5,9,11,2});
    }
    static void asscending(int[] arr){
      //  int[] arr = {5, 7, 1, 3, 18, 13};
        for (int i=0;i<arr.length-1;i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    int temp = arr[min];
                    arr[min] = arr[j];
                    arr[j] = temp;
                }
            }
            //System.out.println(arr[min]);
        }
        //enhanced for loop
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }
}
