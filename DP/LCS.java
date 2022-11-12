package com.project.DP;
//length of longest common subsequence
public class LCS {
    //Recursive soln
    public static int lcs(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return 0;
        //both are non empty
        if (s.charAt(0) == t.charAt(0)) {// we found one common elt
            return 1 + lcs(s.substring(1), t.substring(1));
        } else {
            //else i.e first char of both string are not matching
            int option1 = lcs(s, t.substring(1));//to check 1st char of s is present in remaining string t//1st char of s may be part of lcs
            int option2 = lcs(s.substring(1), t);//to check 1st char of t is present in remaining string s
            int option3 = lcs(s.substring(1), t.substring(1));//those two 1st char are not part of lcs //not present in remaining string
            return Math.max(Math.max(option1, option2), option3);
        }
    }
    public static int lcsDP(String s, String t){
        int m=s.length();int n=t.length();
       int dp[][]=new int[m+1][n+1];//for i,j cell lcs when i characters left in string s and j characters left in string t
       ////by defult

       // 1st row 0;
        for (int j = 0; j <=n ; j++) {
            dp[0][j]=0;
        }
        // 1st col 0;
        for (int i = 0; i <=m ; i++) {
            dp[i][0]=0;
        }
        for (int i=1;i<=m;i++){
           for (int j = 1; j <=n ; j++) {
               if (s.charAt(m-i) == t.charAt(n-j)){
                   dp[i][j]=1+dp[i-1][j-1];
               }
               else
                   dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
               }
           }
        return dp[m][n];
    }
//    Edit Distance of two strings is minimum number of operations required to make one string equal to other. In order to do so you can perform any of the following three operations only :
//1. Delete a character
//2. Replace a character with another one// dont swap
//3. Insert a character
    // we are not actually update the string just assume above operations performed and count requird
    public static int editDistance(String s1, String s2){
        if (s1.length()==0)//"" "abc"
            return s2.length();//we have to insert 3 characters or delete 3 characters to make both the string equal
        if (s2.length()==0)// "abcd" ""
            return s1.length();//we have to insert/delete 4 characters
  if (s1.charAt(0)==s2.charAt(0))
      return editDistance(s1.substring(1), s2.substring(1));
  //at this stage found that we should perform atleast one operation
        int opt1=editDistance(s1,s2.substring(1));//insert gd,age
        int opt2=editDistance(s1.substring(1),s2);//delete age,gd
int opt3=editDistance(s1.substring(1),s2.substring(1));//replace age,bhe
  return 1+Math.min(Math.min(opt1,opt2),opt3);
    }// here we are making repeatitive calls
    public static int editDistanceDP(String s, String t) {
        int m=s.length();int n=t.length(); // dim : length cell:edit distance
        int dp[][]=new int[m+1][n+1];
        for (int i = 0; i <=m ; i++) {
            dp[i][0]=i;
        }
        for (int j = 0; j <=n; j++) {
            dp[0][j]=j;
        }
        for (int i=1;i<=m;i++){
            for (int j = 1; j <=n ; j++) {
                if (s.charAt(m-i) == t.charAt(n-j)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                    dp[i][j]=1+Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1] );
            }
        }
        return dp[m][n];
    }
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight,int sidx) {//return max value
        // if thief stole 1st and 2nd item then return value[0]+value[1]
        if (maxWeight==0||sidx==weights.length)
            return 0;
        if (weights[sidx]>maxWeight)
            return knapsack(weights, values, n, maxWeight, sidx+1);
        else {
           int opt1= values[sidx]+knapsack(weights, values, n, maxWeight - weights[sidx], sidx+1);//include sidx item
           int opt2= knapsack(weights, values, n, maxWeight, sidx+1) ;
           return Math.max(opt1,opt2);// choose thosse options corresponding to ehich thief will get max value

        }
    }

    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
      //maxWeight=bag capacity
        return knapsack(weights, values, n, maxWeight,0);

    }
    static int knapsackDP(int[] weight, int[] value, int n, int maxWeight) {
   int dp[][]=new int[n+1][maxWeight+1];//sidx*weigth
        for (int i=n-1;i>=0;i--)
        {
            for (int w=0;w<=maxWeight;w++)
            {
                if (weight[i]<=w)
                {
                    int ans1=dp[i+1][w];//dont include and move on
                    int ans2=dp[i+1][w-weight[i]] + value[i];//include and move on
                    dp[i][w]=Math.max(ans1, ans2);
                }
                else
                {
                    dp[i][w]=dp[i+1][w];
                }
            }
        }
        return dp[0][maxWeight];
    }
    public static int findMaxSquareWithAllZerosDP(int[][] input){
   int m=input.length;//rows
        if(m==0)
            return 0;
         int n=input[0].length;//col
        if(n==0)
            return 0;

        int dp[][]  =new int[m][n]   ;
   //dp[i][j]:whats the length of largest square matrix with all zeros, ending at (i,j)
   //fill first col
        for (int i = 0; i <m ; i++) {
          if(input[i][0]==0)
              dp[i][0]=1;
              //// by default there will be 0
         // else dp[i][0]=0;  //input[i][0]==1
        }
//fill first row
        for (int j = 0; j <n ; j++) {
            if(input[0][j]==0)
                dp[0][j]=1;
            //// by default there will be 0
           // else dp[0][j]=0;  //input[0][j]==1
        }
        int maxValue=0;
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                if (input[i][j]==0){
                    int opt1=dp[i-1][j-1];//diag
                    int opt2=dp[i][j-1];//left
                    int opt3=dp[i-1][j];//up
                    dp[i][j]=Math.min(Math.min(opt1,opt2),opt3)+1;
                }
                if (dp[i][j]>maxValue)
                    maxValue=dp[i][j];
                // by default there will be 0
//                else//input[i][j]==1
//                    dp[i][j]=0;
            }
        }
        return maxValue;
    }

        static boolean isSubsetPresent(int set[], int n, int sum)  {
            // Base Cases
            if (sum == 0)
                return true;
            if (n == 0)
                return false;
            // If last element is greater than
            // sum, then ignore it
            if (set[n - 1] > sum)
                return isSubsetPresent(set, n - 1, sum);
        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
            return isSubsetPresent(set, n - 1, sum) || isSubsetPresent(set, n - 1, sum - set[n - 1]);
        }




    public static void main(String[] args) {
  String s="agih";
  String t="bhigh";
//        System.out.println(lcs(s,t));
//        System.out.println(lcs(s,s));//best case:O(length(s))
//        System.out.println(lcsDP(s,t));
//        System.out.println(lcsDP(s,s));
//        System.out.println(editDistance("abc", "bam"));
//        System.out.println(editDistanceDP("abc","bam"));
//        System.out.println(editDistanceDP("abcd",""));
//        int weights[]={6,1,2,4,5};
//        int values[]={10,5,4,8,6};
//        int maxweight=5;
//       // System.out.println(knapsack(weights,values,weights.length,maxweight));//[1,4]=weight,13=value
//        System.out.println(knapsackDP(weights,values,weights.length,maxweight));
//        int input[][]={{1,1},{1,1}};
//        int[][] input1 ={{1, 1, 0}, {1, 1 ,1,},{1, 1 ,1}};
//        System.out.println(findMaxSquareWithAllZerosDP(input));
       // System.out.println(findMaxSquareWithAllZerosDP(input1));


    }

}
