package com.project.Recursion;

public class Keypad {
    public static String[] keypad(int input){
        if(input==0|input==1){
            return new String[]{""};
        }
        String[] smallAns=keypad(input/10);
        String[] options=helper(input%10);

        String ans[]=new String[smallAns.length* options.length];
        int k=0;
        for (int i=0;i<smallAns.length;i++){
           for (int j=0;j<options.length;j++){
               ans[k] = smallAns[i] + options[j];
               k++;

           }
        }
        return ans;

    }
    public static String[] helper(int input){
        if (input==0|input==1)
            return new String[]{""};
        if(input==2)
            return new String[]{"a","b","c"};
        if(input==3)
            return new String[]{"d","e","f"};
        if(input==4)
            return new String[]{"g","h","i"};
        if(input==5)
            return new String[]{"j","k","l"};
        if(input==6)
            return new String[]{"m","n","o"};
        if(input==7)
            return new String[]{"p","q","r","s"};
        if(input==8)
            return new String[]{"t","u","v"};
        if(input==9)
            return new String[]{"w","x","y","z"};
        else
            return null;

    }
    public static void main(String[] args) {
       String []ans= keypad(200);
       for(int i=0;i<ans.length;i++)
           System.out.println(ans[i]+" ");
        //System.out.println(new String[]{""}.length);
    }
}
