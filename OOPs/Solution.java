package com.project;

interface A{
    public void method();
}
interface B{
    public void m();
}

class One{
    public void method(){
        System.out.println("Class One method");
    }
}
class Two extends One implements A{
    public void method(){
        System.out.println("Class Two method");
    }
}
public class Solution extends Two{
    public static void main(String[] args){
        A a = new Two();
        a.method();
    }
}