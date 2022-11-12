package com.project;

import java.util.Arrays;

public class Poly {
    int[] d = new int[250];

    public void setCoefficient(int deg, int coeff) {
        d[deg] = coeff;
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < d.length; i++) {
            if (d[i] != 0)
                System.out.print(d[i] + "x" + i + " ");
        }

    }

    public Poly add(Poly p) {
        for (int i = 0; i < d.length; i++) {
            d[i] = d[i] + p.d[i];
        }
        return this;
    }

    public Poly subtract(Poly p) {
        for (int i = 0; i < d.length; i++) {
            d[i] = d[i] - p.d[i];
        }
        return this;
    }

    public Poly multiply(Poly p) {
        int y[]=new int[d.length];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                int deg = i + j;
                if (deg<d.length)
                   y[deg] += this.d[i] * p.d[j];
            }
        }
        for(int i=0;i<d.length;i++) {
            d[i] = y[i];
        }
        System.out.println(d.length);
        return this;
    }



    public static void main(String[] args){
        Poly p1=new Poly();
        p1.setCoefficient(7,3);
        p1.setCoefficient(1,2);
        p1.setCoefficient(3,1);
        p1.print();
        Poly p2=new Poly();
        p2.setCoefficient(7,3);
        p2.setCoefficient(3,1);
        p2.setCoefficient(1,2);
        p2.print();

       // p1.add(p2);
       // p1.print();
       // p1.subtract(p2);
       // p1.print();
        p1.multiply(p2);
        p1.print();

    }
}