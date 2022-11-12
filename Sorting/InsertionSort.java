package com.project;

public class InsertionSort {
    public static void main(String[]args){
        int[] arr={15,25,5,45,35};
        //consider 1st elt sorted
        for (int i=1;i<arr.length;i++){// execute loop only for unsorted part
            int temp=arr[i];
            int j=i-1; // j is index of sorted part
            while (j>=0 && temp<arr[j]){ // make space until our temporary elt is less than previous one check for all previous one
                if (temp<arr[j])
                    arr[j+1]=arr[j]; // making space to insert elt until while condition satisfy// shift elt towards the right
                //System.out.println(arr[j]);
                j--;
            }
            arr[j+1]=temp;
        }
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
