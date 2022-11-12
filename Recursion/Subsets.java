package com.project.Recursion;

public class Subsets {
    public static int[][] subsets(int input[],int si){
        if(si==input.length){
            int [][] ans=new int[1][0];
            //ans[0][0]=777;
            return ans;
        }
        int[][] smallAns=subsets(input,si+1);
        //int noOfElt=(int) Math.pow(2, input.length-si);
        int [][] ans=new int[smallAns.length*2][];
        int k=0;// track ans array
        for (int i=0;i< smallAns.length;i++){// copy smallAns in ans
            ans[i]=new int[smallAns[i].length];
          //  System.out.println(ans[i].length);
            for (int j=0;j< smallAns[i].length;j++){ // now update ans
                    ans[i][j]=smallAns[i][j];
                }
            k++;
        }
       // System.out.println(k);
        for (int i=0;i< smallAns.length;i++){
            ans[k+i]=new int[smallAns[i].length+1];
            ans[k+i][0]=input[si];

            for (int j=1;j<smallAns[i].length+1;j++){
                ans[k+i][j]=smallAns[i][j-1];
            }


        }
        return ans;
    }
    public static void subsets(int[] input){
         int[][] output=subsets(input,0);
        for(int i = 0; i < output.length; i++) {
            for(int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args){
        subsets(new int[]{5,20,12});
    }
}
