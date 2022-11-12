package com.project.Searching;

public class BinarySearch {
    public static int binarySearchHelp(int input[], int element,int sidx,int lidx) {
        int midx=(sidx+lidx)/2;
        if(sidx>lidx)
            return -1;
        if(input[midx]==element)
            return midx;
        else if(input[midx]<element)
            return binarySearchHelp(input,element,midx+1,lidx);
        else
            return binarySearchHelp(input,element,sidx,midx-1);

    }
    public static int binarySearch(int input[], int element){
        return binarySearchHelp(input, element,0,input.length-1);

    }
    public static void main(String[] a){
        System.out.println(binarySearch(new int[]{},8));
    }
}
