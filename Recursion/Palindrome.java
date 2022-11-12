package com.project.Recursion;

public class Palindrome {
    public static boolean isStringPalindrome(String input){
        return isStringPalindromeHelp(input,0,input.length()-1);
    }
    static boolean b=false;
    public static boolean isStringPalindromeHelp(String input,int startIndex,int lastIndex) {
        if (input.length()==0 | input.length()==1)
            return true;
        if(!(startIndex<lastIndex))
            return b;

        if (input.charAt(startIndex) == input.charAt(lastIndex)) {
            b=true;
            return isStringPalindromeHelp(input, startIndex + 1, lastIndex - 1);
        }
        else
                return false;



    }
    public static void main(String[] args){
        String s=new String("aa");
       // System.out.println(s.length());
        System.out.println(Palindrome.isStringPalindrome(s));
    }
}
