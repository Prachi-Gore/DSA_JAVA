package com.project.DP;

import java.util.HashMap;

public class Fib {
    //Recursion
    public static int fibRec(int n){//O(2^n)
        if (n==0||n==1)
            return n;
        return fibBetterRec(n-1)+fibRec(n-2);
    }
// Memorization technique//top down approach /left to right /fib(n)to fib(0)
    public static int fibBetterRec(int n) {
        int storage[]=new int[n+1];//n+1 unique calls
        for (int i = 2; i <=n ; i++) {
            storage[i]=-1;
        }
        storage[0]=0;storage[1]=1;

       return fibBetterRec(storage,n);
    }
    public static int fibBetterRec(int storage[],int n){

        if (storage[n]!=-1)
            return storage[n];
        storage[n]=fibBetterRec(storage,n-1)+fibBetterRec(storage,n-2);//this way we are not making repeted calls// O(2n+1)=O(n)
       return storage[n];
    }
    //Iteritive//bottom up approach /left to right/ calculate from fib(0)to fib(n)
    public static int fibDP(int n){//without recursion //0(n)//
        int storage[]=new int[n+1];//n+1 unique calls
        storage[0]=0;storage[1]=1;
        for (int i = 2; i <=n ; i++) {
            storage[i]=storage[i-1]+storage[i-2];// we are filling array from starting
        }
       return storage[n];
    }

// min step required to reach step 1
    public static int minStepRec(int n){
        if (n<=1)
            return 0;
        else if (n==2||n==3)
            return 1;
        else {
          int  output1=minStepRec(n-1);
          int output2=Integer.MAX_VALUE;
          int output3=Integer.MAX_VALUE;
          if (n%2==0)
              output2=minStepRec(n/2);
          if (n%3==0)
              output3=minStepRec(n/3);
          return Math.min(Math.min(output1,output2),output3)+1;
        }
    }
    public static int minStepDP(int n){
        if (n==0 || n==1)
            return 0;
        else if (n==2 || n==3)
            return 1;
        int storage[]=new int[n+1];
        storage[0]=0;storage[1]=storage[2]=storage[3]=1;
        for (int i=4;i<=n;i++){
            int output1=storage[i-1];
            int output2=Integer.MAX_VALUE;
            int output3=Integer.MAX_VALUE;
            if (i%2==0)
                output2=storage[i/2];// whatever we calculated recursively in previous qn store it in array at corresponding position
            if (i%3==0)
                output3=storage[i/3];
            storage[i]=Math.min(Math.min(output1,output2),output3)+1;
        }
        return storage[n];
    }
    public static long staircaseRec(int n) {
        if (n==1||n==2)//calculated manually
            return n;
        else if (n==3)
            return 4;// calculated manually
        else//n>=4
           return  staircaseRec(n-1)+staircaseRec(n-2)+staircaseRec(n-3);
    }
    public static long staircaseDP(int n) {
        if (n==1||n==2)//calculated manually
            return n;
        else if (n==3)
            return 4;// calculated manually
        long storage[]=new long[n+1];
        storage[0]=0;storage[1]=1;storage[2]=2;
        storage[3]=4;
        for (int i=4;i<=n;i++){// filled array from start
            storage[i]=storage[i-1]+storage[i-2]+storage[i-3];
        }
        return storage[n];
    }
    public static long balancedBTs(long n) {
         int mod = (int) Math.pow(10, 9) + 7;
         return balancedBTs(n,mod);
    }
    public static long balancedBTs(long n, int mod){// n height of balanced binary tree
        if (n==0||n==1)
            return 1;
        long x=balancedBTs(n-1,mod);
        long y=balancedBTs(n-2,mod);
       return (x*x+2*x*y)%mod;// x*x + x*y + y*x// consider all possible combo
    }

    public static int balancedBTsDP(int height){
        if (height==0||height==1)
            return 1;
        int storage[]=new int[height+1];
        storage[0]=storage[1]=1;
        int mod = (int) Math.pow(10, 9) + 7;
        for (int i=2;i<=height;i++){// filled array from start
            long x=storage[i-1]*storage[i-1];
            x=x%mod;
            long y=2*storage[i-1]*storage[i-2];
            y=y%mod;
            storage[i]=(int)(x+y)%mod;//FOR 2 :1,1 + 1,0  + 0,1
        }
        return storage[height];}
    public static int minCount(int n) {
        if (n == 1)
            return 1;
        int minCount=Integer.MAX_VALUE;
        for (int i = 1; i <=Math.sqrt(n) ; i++) {
             minCount=Math.min(1 + minCount(n - i*i),minCount);
        }
   return minCount;
    }
    public static int minCountDP(int n) {//O(n*root(n))

        int dp[] = new int[n+1];
        for (int i=0;i<n+1;i++)
            dp[i]=-1;

        return minCountHelperDP(n,dp);
    }

    private static int minCountHelperDP(int n, int[] dp)
    {
        if (n==0)
            return 0;

        int count = Integer.MAX_VALUE;
        for (int i=1;i*i<=n;i++)
        {
            if (dp[n-(i*i)]==-1)// calculate only when its not calculated earlier
                dp[n-(i*i)]=minCountHelperDP(n-(i*i),dp);
            count=Math.min(count,1+dp[n-i*i]);
        }

        return count;
    }
    public static long bytelandian(long n, HashMap<Long, Long> memo) {
       //n : original value of coin
        if (n<12){
            memo.put(n,n);// n coin<=n dollar so dont exchange
            return n;
        }
        // we can start from here also
        if (!memo.containsKey(n)){
            long ans1=bytelandian(n/2,memo);
            long ans2=bytelandian(n/3,memo);
            long ans3=bytelandian(n/4,memo);
            long currentValueOfCoin=ans1+ans2+ans3;
            memo.put(n, Math.max(currentValueOfCoin,n));

        }
        return memo.get(n);

    }
    //Iterative solution
    public static long bytelandianIte(long n, HashMap<Long, Long> memo) {
        memo.put((long) 0, (long) 0);
        memo.put((long) 1, (long) 1);

        for (int i = 2; i <= n; i++) {
            long ans1 = memo.get(i / 2);
            long ans2 = memo.get(i / 3);
            long ans3 = memo.get(i / 4);

            long currentValueOfCoin = ans1 + ans2 + ans3;
//            if (currentVal > i) {
//                memo.put((long) i, currentVal);
//            } else {
//                memo.put((long) i, (long) i);
//            }
            memo.put(n, Math.max(currentValueOfCoin,n));
        }
        return memo.get(n);
    }

        public static int maxMoneyLooted(int[] houses) {

            //Handling the base cases where number of houses = 0,1,2
            if (houses.length==0)
                return 0;

            if (houses.length==1)
                return houses[0];

            if (houses.length==2)
                return Math.max(houses[0],houses[1]);

            int n = houses.length;
            int[] dp = new int[n];
            dp[0]=houses[0];
            dp[1]=Math.max(houses[0],houses[1]);
            //n>=3
            for (int i=2;i<n;i++)
            {
                //For every house, we consider two cases
                //Case 1 - Current house is counted as part of the max value => This means the previous house cannot be counted
                int maxVal1=dp[i-2]+houses[i];

                //Case 2 - Current house is not counted as part of the max value => This means previous house can be counted
                int maxVal2=dp[i-1];

                //Max value till current house is maximum of the two possible max values till now
                dp[i]=Math.max(maxVal1,maxVal2);
            }
            //Final element of dp stores max possible value for given number of houses and their respective amounts of loot
            return dp[n-1];
    }
    public static String findWinner(int n, int x, int y) {
        //n==1||x||y first player (beeru)will win
        //if min(x,y)>n i.e both x,y greater than n then ignore them player can move only 1 step eg., n=5,x=7,y=9 ,n=5 x=3,y=10 then ignore y
        //dp array shows who will win at 0,1,2,..i,...,i-x,...i-y,...n coins
        int[] dp = new int[n+1];
        // 0 - Whis wins ; 1 - Beerus wins
        dp[0]=0;
        dp[1]=1;
        //the player who make last move will be our winner
        // 1: beeru win 0:beeru loss consider perspective of one player
// winning of beeru at nth coin is depend on its state on n-1,n-x,n-y(to win finally ,any one state from this should loose)
        for (int i=2;i<=n;i++)
        {
            //Beerus wins if dp[i-1] or dp[i-x] or dp[i-y] is 0, i.e, Whis wins when the number of coins is (i-1), (i-x) or (i-y)
            //If none of them are 0, then Beerus cannot win => This means Whis wins for i number of coins
            if (dp[i-1]==0)
            {
                dp[i]=1;
            }
            else if ((i-x)>=0 && dp[i-x]==0)
            {
                dp[i]=1;
            }
            else if ((i-y)>=0 && dp[i-y]==0)
            {
                dp[i]=1;
            }
            else
            {
                dp[i]=0;
            }
            /*
            if (dp[i]==1)
            	System.out.println("For n="+i+" coins, Winner is: Beerus");
        	else
            	System.out.println("For n="+i+" coins, Winner is: Whis");
            */
        }
        if (dp[n]==1)
            return "Beerus";
        else
            return "Whis";
    }
    //min cost path from cell (si,sj)to(m-1,n-1)
    public static int minCostPath(int[][] input){
       return minCostPath(input,0,0);//(si,sj):cell from which we are starting ith and jth index of start cell
    }
    public static int minCostPath( int[][] input,int si,int sj) {
        if (input.length==0)
            return 0;

        int row=input.length;//m
        int col=input[0].length;//n

        // when contains only one elt i.e start cell and end cell both are same(exactly 1)
        if (si==row-1 && sj==col-1)//(0,0)
            return input[si][sj];

        if (si>=row||sj>=col){//last row or last colu
            return Integer.MAX_VALUE;//outof path
        }
        int option1=minCostPath(input,si,sj+1);//right
        int option2=minCostPath(input, si+1, sj);//down
        int option3=minCostPath(input, si+1, sj+1);//diagonal
        return input[si][sj]+Math.min(option1,Math.min(option2,option3));
    }
    public static int minCostPathM( int[][] input) {
        int row=input.length;//m
        int col=input[0].length;//n
        int storage[][]=new int[row][col];

        for (int i=0;i<row;i++){
            for (int j = 0; j < col; j++) {
            storage[i][j]=-1;
            }
        }
        storage[row-1][col-1]=input[row-1][col-1];//last entry of matrix
        return minCostPathM(input,0,0,storage);
    }
    public static int minCostPathM( int[][] input,int si,int sj,int[][]storage) {
        int row = input.length;//m
        int col = input[0].length;//n

        if (si>=row||sj>=col){//last row or last colu
            return Integer.MAX_VALUE;//outof path
        }
        if (si == row - 1 && sj == col - 1) {//last entry of matrix
            storage[si][sj] = input[si][sj];
            return storage[si][sj];
        }
        if (storage[si][sj]==-1){
            //Memorization
            int option1=minCostPathM(input,si,sj+1,storage);//right
            int option2=minCostPathM(input, si+1, sj,storage);//down
            int option3=minCostPathM(input, si+1, sj+1,storage);//diagonal
            storage[si][sj]= input[si][sj]+Math.min(option1,Math.min(option2,option3));
        }
        return storage[si][sj];
    }
    public static int minCostPathDP( int[][] input) {
        int row=input.length;//m
        int col=input[0].length;//n
        int dp[][]=new int[row][col];

//        for (int i=0;i<row;i++){
//            for (int j = 0; j < col; j++) {
//                dp[i][j]=-1;
//            }
//        }
        dp[row-1][col-1]=input[row-1][col-1];//last entry of matrix//last row last col
        //last row
        for (int j=col-2;j>=0;j--){// now feel last row from 2nd last col to 1st col//filling right to left
            dp[row-1][j]=input[row-1][j]+dp[row-1][j+1];
        }
        //last col
        for (int i=row-2;i>=0;i--){// now feel last col from 2nd last row to 1st row//filling bottom to top
            dp[i][col-1]=input[i][col-1]+dp[i+1][col-1];
        }
        //now fill remaining rows : har ek row me jao and corresponding col feel kro
        for (int i = row-2; i >=0; i--) {
            for (int j = col-2; j >=0; j--) {
               // if (dp[i][j]==-1){
                    int option1=dp[i][j+1];//right
                    int option2=dp[i+1][j];//down
                    int option3=dp[i+1][j+1];//diagonal
                    dp[i][j]= input[i][j]+Math.min(option1,Math.min(option2,option3));
            }
        }
        return dp[0][0];
    }
    
    public static void main(String[] args) {
//        System.out.println(Fib.fibBetterRec(4));// 9 calls in which 5 unique calls
//        System.out.println(fibRec(4));// 9 calls
//        System.out.println(fibDP(4));
//        System.out.println(minStepRec(3));
//        System.out.println(minStepRec(2));
//        System.out.println(minStepRec(1));
//        System.out.println(minStepRec(4));
//        System.out.println(minStepRec(5));
//        System.out.println(minStepRec(10));
        // this will fail when n=10
        // 10 5 4 2 1 :4 steps//10 9 3 1 :3 steps
       // System.out.println(staircaseRec(5));
      //  System.out.println(minCostPath(new int[3][2]));
        int input[][]={{1,1,1},{4,5,2},{7,8,9}};
        System.out.println(minCostPathDP(input));
    }
}
