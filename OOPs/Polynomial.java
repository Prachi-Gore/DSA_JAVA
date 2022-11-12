package com.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Polynomial {
     Scanner s=new Scanner(System.in);
     int n=s.nextInt(); // degree
     int[] coeff=new int[n+1]; // 0 to n
    void setCoefficient(int degree,int coefficient){
          coeff[degree]=coefficient;
    }
    void print(){
        for (int i=0;i< coeff.length;i++){
            System.out.print(coeff[i]+"x^"+i);
            if (n!=i)
                System.out.print("+");
            else
                break;
        }

    }
    Polynomial result=new Polynomial();
    Polynomial add(Polynomial p1,Polynomial p2) {

        for (int i = 0; i < coeff.length; i++) {
           result.coeff[i] = p1.coeff[i] + p2.coeff[i];
        }
        return result;
    }


    public static void main(String[] args) {
        Polynomial p1=new Polynomial();
        p1.setCoefficient(1,5);
        p1.setCoefficient(0,3);
        p1.setCoefficient(2,8);
        p1.print();
        Polynomial p2=new Polynomial();
        p2.setCoefficient(1,4);
        p2.setCoefficient(0,2);
        p2.setCoefficient(2,1);
        p2.print();
        Polynomial result=new Polynomial().add(p1,p2);
        result.print();




    }
}

