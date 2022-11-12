package com.project.BitManipulation;

import java.util.Arrays;

public class Unique {

    public static int findUnique(int[] arr) {
        int ans=0;
        for (int elt:arr) {
            ans=ans^elt;
        }
        return ans;
    }
    public static int findDuplicate(int[] arr) {
        int n=arr.length;
        int sum=(n-2)*(n-1)/2;
        int ans=0;
        for (int elt:arr) {
            ans=ans+elt;
        }
        return ans-sum;

    }
    public static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);Arrays.sort(arr2);
        int i=0;// for arr2
        int j=0;// for arr2
        while (i<arr1.length&&j<arr2.length){
            if(arr1[i]==arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
            else if(arr1[i]<arr2[j]){
                i++;
            }
            else{
                j++;
            }

        }// TC MIN(o(length(arr1),length(arr1)))

    }
    public static int pairSum(int[] arr, int num) {
        int count=0;
          for (int i=0;i<arr.length;i++){
              for (int j=i+1;j<arr.length;j++){
                  if (arr[i]+arr[j]==num)
                      count++;
              }
          }
          return count;
    }
    public static int tripletSum(int[] arr, int num) {
        Arrays.sort(arr);
        int n = arr.length;

        int numTriplets = 0;

        for (int i=0; i<n; i++) {
            int pairSum = num - arr[i];
            int numPairs = 0;

            int start = i + 1;
            int stop = n - 1;

            while (start < stop) {
                if (arr[start] + arr[stop] < pairSum) {
                    start++;
                } else if (arr[start] + arr[stop] > pairSum) {
                    stop--;
                } else {
                    if (arr[start] == arr[stop]) {
                        int totalCount = (stop - start) + 1;
                        numPairs += (totalCount * (totalCount - 1) / 2);
                        break;
                    }

                    int tempI = start + 1;
                    int tempJ = stop - 1;

                    while (tempI <= tempJ && arr[start] == arr[tempI]) {
                        tempI++;
                    }

                    while (tempI <= tempJ && arr[stop] == arr[tempJ]) {
                        tempJ--;
                    }

                    int totalElementFromStart = (tempI - start);
                    int totalElementFromEnd = stop - tempJ;

                    numPairs += (totalElementFromStart * totalElementFromEnd);

                    start = tempI;
                    stop = tempJ;
                }
            }
            numTriplets += numPairs;
        }
        return numTriplets;
    }

    public static void main(String[] args) {
       // System.out.println(findUnique(new int[]{5,8,7,8,7}));
      //  System.out.println(findDuplicate(new int[]{0,1,2,3,0}));
      //  intersection(new int[]{5,8,7,8,7},new int[]{51,8,7,8,17});
      //  intersection(new int[]{1,2,3,4},new int[]{51,8,7,8,17});
        System.out.println(pairSum(new int[]{2,2,2},4));
        System.out.println(pairSum(new int[]{3,2,12,7,5,10,9},13));
        System.out.println(tripletSum(new int[]{2,2,2},6));
    }
}
