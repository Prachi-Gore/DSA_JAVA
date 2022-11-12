package com.project;

public class Fraction {
     int numerator;
    int denominator;
    Fraction(int numerator,int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {

        }
        this.denominator = denominator;
        simplify();
    }
         private void simplify() {
            int gcd = 1;
            int smaller = Math.min(numerator, denominator);
            for (int i = 1; i <= smaller; i++) {
                if (numerator % i == 0 && denominator % i == 0)
                    gcd = i;
            }
            numerator = numerator / gcd;
            denominator = denominator / gcd;
        }
        int getNumerator () {
            return numerator;
        }
        int getDenominator () {
            return denominator;
        }
        void setNumerator ( int n){
            this.numerator = n;
            simplify();
        }
        void setDenominator ( int d){
            if (d == 0)
                return;
            this.denominator = d;
            simplify();
        }
        void print(){
        if(denominator==1)
            System.out.println(numerator);
        System.out.println(numerator+"/"+denominator);
    }
   void add(Fraction f2){
     this.numerator=this.numerator* f2.denominator+ f2.numerator*this.denominator;
     this.denominator=this.denominator*f2.denominator;
     simplify();
    }
   void multiply(Fraction f2){
        this.numerator=this.numerator* f2.numerator;
        this.denominator=this.denominator*f2.denominator;
        simplify();
    }
      void add(Fraction f1, Fraction f2){
        this.numerator=f1.numerator* f2.denominator+ f2.numerator*f1.denominator;
        this.denominator=f1.denominator*f2.denominator;
        simplify();
    }

}
