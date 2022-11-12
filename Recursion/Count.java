package com.project.Recursion;

import java.util.concurrent.Callable;

// count no. of digits in n
public class Count {
    //static int c = 0;

   /* public static int count(int n) {
        if (n == 0) {
            return 1;
        } else {

            c++;
            count(n / 10);
            return c;
        }

    }*/
   static boolean a=false;
    public static int countZerosRecHelp(int n){
        if(n==0)
            return 0;
        if(n%10==0) {
            a=true;
            return 1 + countZerosRecHelp(n / 10);
        }
        else
            return countZerosRecHelp(n/10);
    }
    public static int countZerosRec(int n){
        if(n==0 & a==false)
            return 1;
        else
            return countZerosRecHelp(n);
    }
    public static double findGeometricSum(int k){
        if(k==0)
            return 1;
        return Math.pow(0.5,k)+ findGeometricSum(k-1);
    }


    public static void main(String[] args) {
       // int ans=Count.count(0);
       // System.out.println(ans);
        System.out.println(countZerosRec(1010000005));

       // System.out.println(002);

    }

}
