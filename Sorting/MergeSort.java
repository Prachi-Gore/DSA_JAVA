package com.project.Sorting;

public class MergeSort {
    public static void divide(int [] input,int sI,int eI){
        if(sI==eI)
            return;
        int mI=(sI+eI)/2;
        divide(input,sI,mI);
        //System.out.println(sI+" "+eI);
        divide(input,mI+1,eI);
       // System.out.println(sI+" "+eI);
        merge(input,sI,eI);
    }
    public static void merge(int[]input,int sI,int eI) {
        int mI = (sI + eI) / 2;
        int[] ans = new int[eI - sI + 1];
        //System.out.println(sI+" "+eI+" "+ans.length);
        int i = sI;
        int j = mI + 1; // sI of another part
        int k = 0;
        while (i <= mI & j <= eI) {
            if (input[i] < input[j]) {
                ans[k] = input[i];
                i++;
                k++;
            } else {
                ans[k] = input[j];
                j++;
                k++;
            }
        }
        while (i <= mI) {
            ans[k] = input[i];
            i++;
            k++;
        }
        while (j <= eI) {
            ans[k] = input[j];
            j++;
            k++;
        }
        for (int index = 0; index < ans.length; index++) {
            input[sI + index] = ans[index];
        }
    }
        public static void main(String[] args){
            int[] arr=new int[]{8,7,1,5,2,6};
            divide(arr,0,5);
            for (int i:arr) {
                System.out.print(i+" ");
            }

        }

    }


