package com.project.Stack;

import java.util.*;
public class Check {


        public static boolean checkRedundantBrackets(String expression) {
            //Your code goes here
            Stack<Character> stack=new Stack<Character>();
            int count=0;
            for(int i=0;i<expression.length();i++)
            {
                char c=expression.charAt(i);
                //System.out.print(c);

                if (c==')')
                {
                    //System.out.println();
                    while(!stack.isEmpty() && stack.peek()!='(')
                    {
                        count=count+1;
                        stack.pop();
                        //System.out.print(stack.pop());
                    }
                    //System.out.println();
                    //System.out.println(count);
                    if (count==0 || count==1)
                    {
                        return true;
                    }
                    stack.pop();
                    count=0;

                }
                else
                {
                    stack.push(c);
                }
            }
            return false;
        }
    public static int[] stockSpan(int[] price) {
        //Your code goes here
        int[] span=new int[price.length];
        Stack<Integer> stack=new Stack<Integer>();
        span[0]=1;
        stack.push(0);

        for (int i=1;i<price.length;i++)
        {
            while(!stack.isEmpty() && price[stack.peek()]<price[i])
            {
                stack.pop();
            }
            //System.out.println(stack.size());

            if (stack.isEmpty())
            {
                span[i]=i+1;
            }
            else
            {
                //System.out.println("i = "+i);
                //System.out.println("top = "+stack.peek());
                span[i]=i-stack.peek();
            }
            stack.push(i);
            //System.out.println("New top: "+stack.peek());
            //System.out.println();
        }
        return span;

    }
    public static int countBracketReversals(String input) {

        if (input.length()%2!=0)
        {
            return -1;
        }
        Stack<Character> stack=new Stack<Character>();
        int count=0;
        for (int i=0;i<input.length();i++)
        {
            char c=input.charAt(i);
            if (c=='{')
            {
                stack.push(c);
            }
            else
            {
                if (stack.isEmpty())
                {
                    stack.push(c);
                }
                else if (stack.peek()=='}')
                {
                    stack.push(c);
                }
                else if (stack.peek()=='{')
                {
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty())
        {
            char c1=stack.pop();
            char c2=stack.pop();

            if (c1==c2)
            {
                count=count+1;
            }
            else
            {
                count=count+2;
            }
        }
        return count;

    }


}




