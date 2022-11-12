package com.project.Recursion;

public class Check {
    public static boolean checkNumber(int[] input,int x){
             if (input.length==0)
                 return false;
             if(input.length==1){
                 if (input[0]==x)
                     return true;
                 return false;
             }
             if (input[0]==x)
                 return true;
             else {
                 int n = input.length;
                 int[] small = new int[n - 1];

                 for (int i = 0; i < small.length; i++) {
                     small[i] = input[i + 1];
                 }
                 return checkNumber(small, x);
             }
    }

    public static boolean checkAB(String input) { //a,aa,abb,abba
        int l=input.length();
        if (l == 0) {
            return true;
        }
        boolean smallAns=false;
        if (l==1) {
            if (input.charAt(0) == 'a') {
                smallAns = true;
            }
            input="";


        }
       else if (l==2){
          if (input.charAt(0)=='a'&input.charAt(1)=='a') {
              smallAns = true;
          }
          input="";

        }
        else if(l>=3){
            if (input.charAt(0) == 'a' & input.charAt(1) == 'b' & input.charAt(2) == 'b'){
                smallAns=true;
            input=input.substring(3);
        }
        else if(input.charAt(0)=='a' &input.charAt(1)=='a'){
          smallAns=true;
          input=input.substring(1);
        }


        }
      return   smallAns & checkAB(input) ;
    }
    public static int staircase(int n){
        if (n==0|n==1) // keep ourselves where we are,1
            return 1;
        if (n==2) // 1 1,2
            return 2;
        if (n==3) // 1 1 1,1 2,2 1,3
            return 4;
        return staircase(n-1)+staircase(n-2)+staircase(n-3);


    }
    public static void main(String[] args){
       // int arr[]={5,4,0,8,10,11,52,-7,2,0};
       // System.out.println(Check.checkNumber(arr,0));
        String s=new String(" ");
        System.out.println(checkAB(s));
    }
}
