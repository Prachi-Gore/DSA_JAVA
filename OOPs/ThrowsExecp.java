package com.project;

class ThrowsExecp {
    static void fun() throws Exception
    {
        throw new Exception();
    }
    public static void main(String args[])
    {
        try {
            fun();
        }
        catch (Exception e) {
            System.out.print("caught in main.");
        }
        System.out.print("All is well");
    }
}
