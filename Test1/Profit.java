package com.project.Test1;


import java.util.Arrays;

public class Profit {
    public static int maximumProfit(int budget[]) {

        Arrays.sort(budget);

        int ans=Integer.MIN_VALUE;
        int n=budget.length;

        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,budget[i]*(n-i));
        }
        return ans;

    }
    public static void main(String[] args){
        System.out.println(maximumProfit(new int[]{30 ,20 ,53 ,14}));
        System.out.println(maximumProfit(new int[]{34 ,78 ,90 ,15 ,67}));

    }
}
