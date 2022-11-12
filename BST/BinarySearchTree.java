package com.project.BST;

import com.project.BinaryTree.BinaryTreeNode;
import com.project.BinaryTree.Pair;
import com.project.LinkedList.Node;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static com.project.BinaryTree.BinaryTreeUse.getMinAndMax;

public class BinarySearchTree {
    //left subtree data<root data<right subtree data
    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
       if (root==null)
           return false;
       if (root.data==k)
           return true;
       if (root.data>k)
          return searchInBST(root.left, k);
       if(root.data<k)
           return searchInBST(root.right,k);
       return false;
    }

    public static void elementsInRangeK1K2Helper(BinaryTreeNode<Integer> root,int k1,int k2, ArrayList<Integer> ans){
        if (root==null)
            return;
        if (k1<=root.data&&root.data<=k2)
            ans.add(root.data);
        if (k2<=root.data)
            elementsInRangeK1K2Helper(root.left,k1,k2,ans);
        else if (k1>= root.data)
            elementsInRangeK1K2Helper(root.right,k1,k2,ans);
        else{
            elementsInRangeK1K2Helper(root.left,k1,k2,ans);
            elementsInRangeK1K2Helper(root.right,k1,k2,ans);
        }
    }


    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
        ArrayList<Integer> ans=new ArrayList<>();
        elementsInRangeK1K2Helper(root,k1,k2,ans);
        Collections.sort(ans);
        for (int elt:ans) {
            System.out.print(elt+" ");
        }
    }

    public static int maximum(BinaryTreeNode<Integer> root){
        if(root==null)
            return Integer.MIN_VALUE;
        return Math.max(root.data,Math.max(maximum(root.left),maximum(root.right)));
    }
    public static int minimum(BinaryTreeNode<Integer> root){
        if(root==null)
            return Integer.MAX_VALUE;
        return Math.min(root.data,Math.min(minimum(root.left),minimum(root.right)));

    }
    public static boolean isBST(BinaryTreeNode<Integer> root) {// O(nlogn) // not good approach
        if(root==null)
            return true;
        int leftmax=maximum(root.left);
        int rightmin=minimum(root.right);
        //if (leftmax<=root.data&&root.data<=rightmin)
        //    ans= true;
        if (leftmax>=root.data )
            return false;
        if(root.data>rightmin)
            return false;
        return isBST(root.left)&&isBST(root.right);
    }
    public static Pair<Boolean,Pair<Integer,Integer>> isBST2(BinaryTreeNode<Integer> root){//O(n)
        if (root==null){ // boolean min max
            Pair<Boolean,Pair<Integer,Integer>> output=new Pair<>(true,new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE));
           return output;
        }
        Pair<Boolean,Pair<Integer,Integer>>leftOutput=isBST2(root.left);
        Pair<Boolean,Pair<Integer,Integer>>rightOutput= isBST2(root.right)  ;
        int min=Math.min(root.data,Math.min(leftOutput.second.first,rightOutput.second.first));
        int max=Math.max(root.data,Math.max(leftOutput.second.second,rightOutput.second.second ));
        boolean isBst=(root.data>leftOutput.second.second)&&(root.data<rightOutput.second.first)&&leftOutput.first&&rightOutput.first;
        Pair<Boolean,Pair<Integer,Integer>> output=new Pair<>(isBst,new Pair<>(min,max));
        return output;
    }
    public static boolean isBst3(BinaryTreeNode<Integer> root,int min,int max){//O(n)
        if (root==null)
            return true;
        if (root.data<min||root.data>max)// root is outoff range
            return false;
        boolean isLeftOk=isBst3(root.left,min,root.data-1);
        boolean isRightOk=isBst3(root.right,root.data+1,max);// or min=root.data
        return isLeftOk & isRightOk;
    }
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr,int sidx,int eidx){
        if(sidx>eidx)// traverse has been completed
            return null;
        int midx = (sidx + eidx) / 2;
        int rootData = arr[midx];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        if(sidx<eidx){
            root.left = SortedArrayToBST(arr, sidx, midx - 1);
            root.right = SortedArrayToBST(arr, midx + 1, eidx);
        }
        return root;
    }
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
            return   SortedArrayToBST(arr,0,n-1);
    }
    public static ArrayList<Integer> getPathRootToNode(BinaryTreeNode<Integer> root, int data){
        //Node is a node corresponding to data
        if (root==null)
            return null;
        if (root.data==data) {
           ArrayList<Integer> output= new ArrayList<Integer>();
           output.add(root.data);
            return output;
        }
        ArrayList<Integer>leftOutput=getPathRootToNode(root.left,data);
        if (leftOutput!=null) {
            leftOutput.add(root.data);
            return leftOutput;
        }
        ArrayList<Integer>rightOutput=getPathRootToNode(root.right,data);
        if (rightOutput!=null) {
            rightOutput.add(root.data);
            return rightOutput;
        }
        return null;
    }
    //get path root to node for binary search tree
    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
        if (root==null)
            return null;
        if (root.data==data){
            ArrayList<Integer> output= new ArrayList<Integer>();
            output.add(root.data);
            return output;
        }
        else if (root.data<=data){
            ArrayList<Integer>rightOutput= getPath(root.right,data);
            if (rightOutput!=null) {
                rightOutput.add(root.data);
                return rightOutput;
            }
            return null;
        }
        //if (data<root.data){
        else{
            ArrayList<Integer>leftOutput= getPath(root.right,data);
            if (leftOutput!=null) {
                leftOutput.add(root.data);
                return leftOutput;
            }
            return null;
        }

    }
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
            if (root==null)
                return;
            // int duplicateData=root.data;
            BinaryTreeNode<Integer> duplicateNode=new BinaryTreeNode<>(root.data);
            BinaryTreeNode<Integer>tempNode=root.left;
            root.left=duplicateNode;
            duplicateNode.left=tempNode;
            insertDuplicateNode(root.left.left);
            insertDuplicateNode(root.right);

    }
    //Binary Search Tree
    static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {

        if(root==null)
            return -1;
       // If both n1 and n2 are smaller than root, then LCA lies in left
        if (a< root.data&&b<root.data)
            return getLCA(root.left,a,b);
        //If both n1 and n2 are greater than root, then LCA lies in right
        else if(a> root.data&&b>root.data)
            return getLCA(root.right,a,b);
        else//dono ke path alag ho rahe hai one will be in right subtree and one will be in left subtree
           return root.data;

    }
    // if we gonna solve this problem through BST/BT it will take o(n^2)
    static ArrayList<Integer>a=new ArrayList<>();
    public static <a> ArrayList<Integer> toArray(BinaryTreeNode<Integer>root,ArrayList<Integer>a){
        if (root==null)
            return a;

        a.add(root.data);
        toArray(root.left,a);
        toArray(root.right,a);
        return a;
    }
    static void pairSum(BinaryTreeNode<Integer> root, int sum,ArrayList<Integer>a) {
        //convert to array //sort//find pair
        Collections.sort(toArray(root,a));


        int i=0;int j=a.size()-1;
        while (i<j){
           int  elt1=a.get(i);int elt2=a.get(j);
           if (elt1+elt2<sum)
               i++;

           else if(elt1+elt2>sum)
               j--;
           else {
               System.out.println(elt1 + " " + elt2);
               i++;j--;
           }
                   }

    }
   public static void pairSum(BinaryTreeNode<Integer> root, int sum){
        pairSum(root,sum,new ArrayList<>());
    }
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k,String ans) {
        if (root==null)
        return;
        ans+=root.data+" ";
        if (root.left==null&&root.right==null&&root.data==k)
            System.out.println(ans);
        rootToLeafPathsSumToK(root.left,k-root.data,ans);
        rootToLeafPathsSumToK(root.right,k-root.data,ans);

    }
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        rootToLeafPathsSumToK(root,k,"");
    }
    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        // Write your code here
        if (root==null)
            return 0;

        if (isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE))
            return findHeight(root);
        else
        {
            return Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right));
        }

    }

    private static int findHeight(BinaryTreeNode<Integer> root)
    {
        if (root==null)
            return 0;

        if (root.left==null && root.right==null)
            return 1;

        return Math.max(findHeight(root.left),findHeight(root.right))+1;
    }

    private static boolean isBST(BinaryTreeNode<Integer> root, int min, int max)
    {
        if(root == null)
            return true;

        if(root.data < min || root.data > max)
            return false;
        else
            return isBST(root.left,min,root.data -1) && isBST(root.right,root.data +1,max);
    }



    public static void main(String[] args){

    }
}
