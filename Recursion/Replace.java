package com.project.Recursion;

public class Replace {

    public static String replace(String input){
         int startIndex=0;
        if(input.length()<=1)
            return input;
        if(input.charAt(startIndex)=='p' & input.charAt(startIndex+1)=='i') {
            return "3.14"+replace(input.substring(startIndex+2));
        }
        else{

            return input.charAt(startIndex) + replace(input.substring(startIndex+1));
        }
    }

    public static String removeX(String input){
         int startIndex=0;
        if(input.length()==0)
            return input;
        if (input.charAt(startIndex)=='x') {
          return removeX(input.substring(startIndex + 1));

        }
        else{
            return input.charAt(startIndex)+removeX(input.substring(startIndex + 1));
        }
    }

    public static int convertStringToInt(String input){
        int startIndex=0;
       if(input.length()==0){
           return 0;
       }
       else{
         return  ( (int) input.charAt(startIndex)-48)*(int) Math.pow(10,input.length()-1)+convertStringToInt(input.substring(startIndex+1));

       }
    }

    public static String replaceCharacter(String input, char c1, char c2) {

        int startIndex=0;
        if(input.length()==0)
            return input;
        if(input.charAt(startIndex)==c1) {
            return c2+  replaceCharacter(input.substring(startIndex+1),c1,c2);
        }
        else{

            return input.charAt(startIndex) + replaceCharacter(input.substring(startIndex+1),c1,c2);
        }
    }
    public static void main(String[] args){
        String s=new String("qpMm1");
        //String ans=replace(s);
        //System.out.println(ans.toCharArray());
       // String ans=removeX(s);
        //System.out.println(ans.toCharArray());
       // System.out.println(convertStringToInt("00"));
      //   String ans=replaceCharacter(s,'M','A');
      //  System.out.println(ans);
        for(int i = 0; i < 5; i++){
            for(; i < 5; i++){
                System.out.println(i);
            }
        }

    }
}
