package com.project.Test1;

public class Contains {
    // To check whether a contains b
    public static boolean checkSequence(String a, String b) {
        return checkSequence(a,b,0,0);
    }

    public static boolean checkSequence(String a, String b, int a_idx, int b_idx) {
        if (b_idx==b.length())
        {
            return true;
        }
        if (a_idx==a.length())
        {
            return false;
        }
        if (b.charAt(b_idx)==a.charAt(a_idx))
        {
            return checkSequence(a,b,a_idx+1,b_idx+1);
        }
        else
        {
            return checkSequence(a,b,a_idx+1,b_idx);
        }

    }
    public static void main(String[] args){
        System.out.println(checkSequence("acd b"," "));
        System.out.println(checkSequence("",""));
        System.out.println(checkSequence("abcd","wd"));
    }

}

