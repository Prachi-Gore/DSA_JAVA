package com.project.Hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Hash {
    public static ArrayList<Integer> removeDuplicates(int arr[]) {
        ArrayList< Integer>output=new ArrayList<>();
        HashMap<Integer,Boolean>seen=new HashMap<>();
        for (int i=0;i< arr.length;i++){
            if (seen.containsKey(arr[i]))//O(1)
                continue;
            output.add(arr[i]);
            seen.put(arr[i],true);//O(1)
        }
        return output;
    }

    public static int freq(int n,int[]arr) {
        int count=0;
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == n)
                count++;
            //continue;
        }
        return count;
    }
    public static int maxFrequencyNumber(int[] arr){
//        if (arr.length==0)
//            return -1;
        HashMap<Integer,Integer> output=new HashMap<>();
        for (int i=0;i< arr.length;i++){
            if (output.containsKey(arr[i]))
                continue;
            output.put(arr[i],freq(arr[i],arr ) );
        }
        int maxCount=output.get(arr[0]);int maxElt=arr[0];
        for (int i=1;i< arr.length;i++){
            if (output.get(arr[i])>maxCount){
                maxCount=output.get(arr[i]);
                maxElt=arr[i];
            }
        }
        return maxElt;
    }
    public static int PairSum(int[] input, int size) {
     if(size==0)
         return 0;
     HashMap<Integer,Integer>map=new HashMap<>();//frequency map
        for (int key:input) {
            if (map.containsKey(key))
                map.put(key,map.get(key)+1);
            else
                map.put(key,1);
        }
        int countPairs=0;
        for (int i: map.keySet()){
            if (map.containsKey(-i)&&i!=0)
                countPairs+=map.get(i)* map.get(-i);
            if (i==0) {
                int rep=map.get(0);
                countPairs +=rep*(rep-1);//ncr formula
            }
        }
        return countPairs/2;
    }
    public static void printIntersection(int[] arr1,int[] arr2){
HashMap<Integer,Integer>map=new HashMap<>();
        for (int elt:arr1) {
            if (map.containsKey(elt))
                map.put(elt,map.get(elt)+1);
            else
              map.put(elt,1);
        }
        for (int elt:arr2) {
            if (map.containsKey(elt)&& map.get(elt)!=0){
                System.out.println(elt);
                map.put(elt,map.get(elt));
            }
        }
    }
    public static String uniqueChar(String str){
        HashMap<Character,Integer>map=new HashMap<>();
        String ans="";
        for (int i=0;i<str.length();i++) {
            char elt=str.charAt(i);
            if (map.containsKey(elt))
                map.put(elt,map.get(elt)+1);
            else {
                ans+=elt;
                map.put(elt, 1);
            }
        }
        return ans;

    }
    public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {

        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        HashMap<Integer, Integer> lenMap = new HashMap<>();
        for (int i=0;i<arr.length;i++)
        {
            map.put(arr[i],true);
        }
        int maxStart=-1,maxLen=0;
        boolean startCheck=true;

        for (int i: arr)
        {
            if (map.get(i))
            {
                int currStart=i,currLen=1;
                //System.out.println("Current start of sequence: "+currStart);
                //System.out.println("Current length of sequence: "+currLen);
                boolean flag=true;
                map.put(i,false);

                int ahead=i+1;
                //System.out.println("Checking for values ahead");
                //System.out.println();
                while(flag)
                {
                    if(map.containsKey(ahead))
                    {
                        //System.out.println(ahead+" is included in sequence and status updates to false");
                        currLen=currLen+1;
                        map.put(ahead,false);
                        ahead=ahead+1;
                        //System.out.println("Current length of sequence: "+currLen);
                    }
                    else
                    {
                        flag=false;
                    }
                }
                flag=true;
                int before=i-1;
                //System.out.println();
                //System.out.println("Checking for values before");
                while(flag)
                {
                    if(map.containsKey(before))
                    {
                        //System.out.println(before+" is included in sequence and status updates to false");
                        currLen=currLen+1;
                        currStart=before;
                        map.put(before,false);
                        before=before-1;
                        //System.out.println("Current length of sequence: "+currLen);
                    }
                    else
                    {
                        flag=false;
                    }
                }

                System.out.println();
                if (currLen>=maxLen)
                {
                    maxLen=currLen;
                    maxStart=currStart;
                    lenMap.put(maxStart,maxLen);
                }
            }
            /*
            else
            {
                System.out.println("Element already considered in previous sequence");
            }
            System.out.println();
            */
        }

        //System.out.println("Current start point and length: "+ maxStart+", "+maxLen);
        /*
        for (Integer i: lenMap.keySet())
        {
            System.out.println(i+": "+lenMap.get(i));
        }
        System.out.println();
        */


        for (int i=0;i<arr.length;i++)
        {
            if (lenMap.containsKey(arr[i]) && lenMap.get(arr[i])>=maxLen)
            {
                maxStart=arr[i];
                maxLen=lenMap.get(arr[i]);
                break;
            }
        }
        output.add(maxStart);
        output.add(maxStart+maxLen-1);
        return output;
    }
    public static int getPairsWithDifferenceK(int arr[], int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int key:arr) {
            if (map.containsKey(key))
                map.put(key, map.get(key)+1);
            else
                map.put(key,1);
        }
        int countPairs=0;


        for (int key: map.keySet()){
            if(k==0)
                return map.get(key)*(map.get(key)-1)/2;
            if (map.containsKey(key+k))
                countPairs= countPairs+map.get(key)*map.get(key+k);
            if (map.containsKey(key-k))
                countPairs= countPairs+map.get(key)*map.get(key-k);
        }
        return countPairs/2;
    }
    public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
        // Write your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0,maxLen=-1;
        for (int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            //System.out.println("Current cumulative sum: "+sum);
            if (sum==0)
            {
                maxLen=i+1;
            }
            if (map.containsKey(sum))
            {
                int prevIndex=map.get(sum);
                //System.out.println("Sum found previously at index: "+prevIndex);
                int currLen=i-prevIndex;
                //System.out.println("Length of 0 sum: "+currLen);
                if (currLen>maxLen)
                {
                    maxLen=currLen;
                    //System.out.println("Max Length of 0 sum: "+maxLen);
                }
            }
            else
            {
                //System.out.println("Adding sum to HashMap");
                map.put(sum,i);
            }
            //System.out.println();
        }
        return maxLen;
    }




    public static void main(String[] args) {
           ArrayList<Integer>output=removeDuplicates( new int[] {2,5,2,3,4,4});

        for (int ele:output) {
            System.out.print(ele+" ");
        }
    }
}
