package com.project.Recursion;
class Print {
    public static void print(int n) {
        if (n < 0) {
            return;
        }
        if (n == 0) {
            System.out.println(n);
            return;
        }

       /* System.out.println(n--);
        System.out.println(n);/**/
        print(n--);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int num = 3;
        print(num);// print(3) hi call hoga again & again
    }
}