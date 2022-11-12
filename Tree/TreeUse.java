package com.project.Tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {
    public static TreeNode<Integer> takeInput(Scanner s){
        int n;

        System.out.println("Enter next node data");
        n=s.nextInt();
        TreeNode<Integer>root=new TreeNode<>(n);
        System.out.println("Enter no. of children for "+n);
        int childCount=s.nextInt();
        for (int i=0;i<childCount;i++) {
         TreeNode<Integer> child =takeInput(s);
         root.children.add(child);
        }
        return root;
    }
    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter root data :");
        int rootData= s.nextInt();
        TreeNode<Integer> root=new TreeNode<>(rootData);
        //pendingNodes are those nodes whom childrens are not collected
        Queue<TreeNode<Integer>> pendingNodes=new LinkedList<TreeNode<Integer>>();
        pendingNodes.add(root);
        while (! pendingNodes.isEmpty()){
            TreeNode<Integer> frontNode=pendingNodes.remove();
            System.out.println("Enter number of children of "+frontNode.data );
            int childCount=s.nextInt();
            for (int i=0;i<childCount;i++){
                System.out.println("Enter "+(i+1)+"th "+"child of "+frontNode.data);
                int child=s.nextInt();
               TreeNode<Integer> childNode=new TreeNode<>(child);
                pendingNodes.add(childNode);
               frontNode.children.add(childNode);
            }

        }
        return root;
    }
    public static void print(TreeNode<Integer> root){
        System.out.println(root.data);
      int size= root.children.size();
       // System.out.println(size);
      for (int i=0;i<size;i++){
          print(root.children.get(i));
      }
    }
    public static void print1(TreeNode<Integer> root){
        String s=root.data+" :";

        int size= root.children.size();
        for (int i=0;i<size;i++) {
            s = s  + root.children.get(i).data + ",";
        }
        System.out.println(s);
        for (int i=0;i<size;i++) {
            print1(root.children.get(i));
        }
    }
    public static void printLevelWise(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        Queue<TreeNode<Integer>> cq=new LinkedList<>(); // child queue
        q.add(root);

        while (! q.isEmpty()){
           TreeNode<Integer> frontNode=q.remove();
            System.out.print(frontNode.data+" ");
           for (int i=0;i<frontNode.children.size();i++){
               cq.add(frontNode.children.get(i));
           }
           if (q.size()==0) {
               System.out.println();
               q=cq;
               cq=new LinkedList<>();
           }
        }

    }
    public static int numNodes(TreeNode<Integer> root){
        int count=1;
        // base case in for loop itself no other base case
        for (int i=0;i<root.children.size();i++){
            count+=numNodes(root.children.get(i));
        }
        return count;
    }
    public static int sumNodes(TreeNode<Integer> root){
        int sum= root.data;
        // base case in for loop itself no other base case
        for (int i=0;i<root.children.size();i++){
            sum+=sumNodes(root.children.get(i));
        }
        return sum;
    }
    public static int largestNode(TreeNode<Integer> root)   {
        int ans=root.data;              //Integer.MIN_VALUE
        for (TreeNode<Integer> child: root.children) {
            int childLargest=largestNode(child);
            if (childLargest>ans)
                ans=childLargest;
        }
        return ans;
    }
    public static int numNodeGreater(TreeNode<Integer> root,int x){
        int count=0;
        if (root.data>x)
            count+=1;
        for (TreeNode<Integer> child: root.children) {
             count=count+numNodeGreater(child,x);

        }
        return count;
    }
    public static int getHeight(TreeNode<Integer> root){

        int h=0;
        for (TreeNode<Integer> child: root.children) {
            int childHeight=getHeight(child);
        //    max height (all subtree)+1
            h=Math.max(childHeight,h);
//            if(childHeight>h)
//                h=childHeight;

        }
        return h+1;
    }
    //print all nodes at depth k
    public static void printAtK(TreeNode<Integer> root,int k){
        if (k<0)
            return;
        if (k==0) {//root node
            System.out.print(root.data+" ");
            return;
        }
        for (TreeNode<Integer> child: root.children) {
            printAtK(child, k-1);
        }
    }
//    public static int countLeafNodes(TreeNode<Integer> root){
//
//        if (root==null)
//            return 0;
//        if (root.children.size()==0) // root node itself will be leaf node
//            return 1;
//        int ans=0;
//        for (TreeNode<Integer> child: root.children) {
//            ans+=countLeafNodes(child);
//        }
//        return ans;
//    }
    public static void printPreOrder(TreeNode<Integer> root){ // root-left-right
        System.out.print(root.data+" ");
        for (TreeNode<Integer> child:root.children) {
            printPreOrder(child);
        }

    }
    public static void printPostOrder(TreeNode<Integer> root){ // left-right-root
        for (TreeNode<Integer> child:root.children) {
            printPostOrder(child);
        }
        System.out.print(root.data+" ");
    }
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
          if (root.data==x)
              return true;

        for (TreeNode<Integer> child: root.children) {
            boolean ans= checkIfContainsX(child, x);
            if (ans)
                return ans;
        }
        return false;
    }
    public static int sum(TreeNode<Integer> root){
        int sum=root.data;
        for (TreeNode<Integer> child:root.children) {
            sum+= child.data;
        }
        return sum;
    }
    //wo node jiske corresponding node + children sum max hai
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
       int maxSum=Integer.MIN_VALUE; // initially max sum
       TreeNode<Integer> maxNode=null;// initially node corresponding to max sum
       //dont start to check from root node : will get root as ans as we are comparing with min value
        for (TreeNode<Integer> child:root.children) {
            // node corresponding to each max child sum
            TreeNode<Integer> childNode=maxSumNode(child);
            int childSum=sum(childNode);
            if (childSum>maxSum){
                maxSum=childSum;
                maxNode=childNode;
            }
        }
        // after getting max node from child compare it with root node
        if (sum(root)>maxSum){
           maxSum=sum(root);
          maxNode=root;
        }
        //return maxNode;
       return maxNode;
    }
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

        // Write your code here
        if(root1==null && root2==null)
            return true;
        if(root1.data!=root2.data)
            return false;
        if(root1.children.size()!=root2.children.size())
            return false;
        for(int i=0;i<root1.children.size();i++){
            if(!checkIdentical(root1.children.get(i),root2.children.get(i)))
                return false;
        }
        return true;
    }
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
//        if (root==null)
//            return root;
        TreeNode<Integer> ans=null;
     if (root.data>n) {
         //if (ans==null||ans.data<root.data)
               ans = root;
     }
     for (TreeNode<Integer> child:root.children) {
           TreeNode<Integer> childMax=findNextLargerNode(child, n);
           if (childMax==null)
               continue;// continue for next child
           else{
               if (ans==null)
                   ans=childMax;
               else if(childMax.data>n & childMax.data< ans.data)
                   ans=childMax;
           }
        }

     return ans;
    }
    public static int countLeafNodes(TreeNode<Integer> root){
        int count=0;
        if (root.children.size()==0)
            return count+1;
        for (TreeNode<Integer> child:root.children)
            count=count+countLeafNodes(child);

        return count;
    }
    //ceil atmost & floor atleast
    public static TreeNode<Integer> largest;
    public static TreeNode<Integer> secondLargest;

    // Helper Function to find the second largest node of the n-ary tree
    public static void findSecondLargestHelper(TreeNode<Integer> root)
    {
        if (root == null)
            return;

        // Check if root's data is larger than current largest node's data
        if (root.data > largest.data) {
            secondLargest = largest;
            largest = root;
        } else if (root.data > secondLargest.data && root.data != largest.data)
            secondLargest = root;

        // recursively find second largest in children
        for (TreeNode<Integer> child: root.children)
            findSecondLargestHelper(child);
    }

    // Function to find the second largest node of the n-ary tree
    public static TreeNode<Integer> findSecondLargest(TreeNode <Integer> root)
    {

        // Initialising the pointers to a node with value negative infinity
        largest = new TreeNode<Integer>(Integer.MIN_VALUE);
        secondLargest = largest;

        findSecondLargestHelper(root);
        return secondLargest;
    }

    public static void main(String[] args) {
//        // create individual nodes
//        TreeNode<Integer> root=new TreeNode<>(4);
//        TreeNode<Integer> node1=new TreeNode<>(2);
//        TreeNode<Integer> node2=new TreeNode<>(3);
//        TreeNode<Integer> node3=new TreeNode<Integer>(9);
//        TreeNode<Integer> node4=new TreeNode<>(5);
//        TreeNode<Integer> node5=new TreeNode<>(7);
//        // connect them
//        Collections.addAll(root.children,node1,node2,node3);
//        Collections.addAll(node2.children,node4,node5);
//
//        System.out.println(root.data);
//        System.out.println(root.children.get(1).data);
//    }
//        Scanner s=new Scanner(System.in);
//        TreeNode<Integer> root=takeInput(s);
  //      print1(root);
   //     print1(takeInputLevelWise());
    //    printLevelWise(takeInputLevelWise());
       // System.out.println(numNodes(takeInputLevelWise()));
       // System.out.println(sumNodes(takeInputLevelWise()));
        TreeNode<Integer> root=takeInputLevelWise();
       // System.out.println(largestNode(root));
       // System.out.println(numNodeGreater(root, 10));
     //   System.out.println(getHeight(root));
      //  printAtK(root, 2);
      //  System.out.println(countLeafNodes(root));
      //  printPreOrder(root);
       // printPostOrder(root);
       // System.out.println(maxSumNode(root).data);
        System.out.println(findSecondLargest(root).data);
    }
}
