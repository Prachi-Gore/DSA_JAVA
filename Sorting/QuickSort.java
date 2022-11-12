package com.project.Sorting;
// Apna College
public class QuickSort {
    public static void quickSort(int[] input,int low,int high){
        if(low<high){
            int pidx=partition(input,low,high);
            quickSort(input,low,pidx-1);
            quickSort(input,pidx+1,high);
        }
    }
    public static int partition(int[] input,int low,int high){
        int pivot=input[high];
        int i=low-1;
        for (int j=low;j<high;j++){
            if(input[j]<pivot){
                i++;
                //swap
                int temp=input[i];
                input[i]=input[j];
                input[j]=temp;
            }
        }
        i++;
       int temp=input[i];
       input[i]=pivot;
       input[high]=temp;
       return i; // pivot index
    }
    public static void quickSort(int[] input){
        quickSort(input,0, input.length-1);
    }
    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 1, 5, 2, 6};
        quickSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
