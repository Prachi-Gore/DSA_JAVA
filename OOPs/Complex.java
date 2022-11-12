package com.project;

public class Complex {
   private int real;
   private int img;
    Complex(int real,int img){
        this.real=real;
        this.img=img;
    }
    void plus(Complex c2){
        real=real+ c2.real;
        img=this.img+ c2.img;
    }
    void print(){
        System.out.println(real+" + "+"i"+img);
    }
    void multiply(Complex c2){
        int r=real; // save real part of the 1st complex no.before it gets modify
        this.real=this.real*c2.real-this.img*c2.img;
        this.img=(r*c2.img)+(this.img* c2.real);
    }
}
