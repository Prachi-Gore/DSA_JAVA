package com.project;

class ExceptionThrown
{
    static int divideByZero(int a, int b){
        int i = a/b;
        return i;
    }
    static int computeDivision(int a, int b) {
        int res =0;
        try
        {
            res = divideByZero(a,b);
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Exception occured");
        }
        return res;
    }
    public static void main(String args[]){
        int a = 1;
        int b = 1;
        int i=0;
        try
        {
            i = computeDivision(a,b);

        }
        catch(ArithmeticException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.print(i);
    }
}