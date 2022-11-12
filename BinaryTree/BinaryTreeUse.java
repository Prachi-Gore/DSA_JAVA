package com.project.BinaryTree;

import com.project.Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class BinaryTreeUse {
    public static BinaryTreeNode<Integer> takeInput(Scanner s) { // using recursion
        System.out.println("enter root data :"); // if user does not want to enter data then enter -1
        int rootData = s.nextInt();
        //  BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
        if (rootData == -1)
            return null;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        root.left = takeInput(s);
        root.right = takeInput(s);
        return root;
    }

    public static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        String ans = root.data + " : ";
        if (root.left != null)
            ans = ans + "L" + root.left.data + " , ";
        if (root.right != null)
            ans = ans + "R" + root.right.data;
        if (root == null)
            return;

        System.out.println(ans);
        printTree(root.left);
        printTree(root.right);
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise() { // using queue
        System.out.println("enter root data: ");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList();
        pendingNodes.add(root);
        while (!pendingNodes.isEmpty()) {
            BinaryTreeNode<Integer> top = pendingNodes.remove();
            if (top.data == -1)
                return null;
            System.out.println("enter left child of " + top.data);
            int left_child = s.nextInt();
            if (left_child != -1) {
                BinaryTreeNode<Integer> left = new BinaryTreeNode<>(left_child);
                pendingNodes.add(left);
                top.left = left;
            }
            System.out.println("enter right child of " + top.data);
            int right_child = s.nextInt();
            if (right_child != -1) {
                BinaryTreeNode<Integer> right = new BinaryTreeNode<>(right_child);
                pendingNodes.add(right);
                top.right = right;
            }
        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
        Queue<BinaryTreeNode<Integer>> cq = new LinkedList<>(); // child queue
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTreeNode<Integer> front = q.remove();
            System.out.print(front.data);
            if (front.left != null) {
                cq.add(front.left);
                System.out.print(":L:" + front.left.data + ",");
            } else
                System.out.print(":L:-1" + ",");
            if (front.right != null) {
                cq.add(front.right);
                System.out.print("R:" + front.right.data);
            } else
                System.out.print("R:-1");
            System.out.println();
            if (q.size() == 0) {
                q = cq;
                cq = new LinkedList<>();
            }
        }
    }

    public static int countNodes(BinaryTreeNode<Integer> root) {
        int count = 0;
        if (root == null)
            return 0;
        else
            count++;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static int getSum(BinaryTreeNode<Integer> root) { // root.data=-1 i.e root=null
        if (root == null)
            return 0;
        int sum = 0;
        sum += root.data;
        sum += getSum(root.left) + getSum(root.right);
        return sum;
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null)
            return false;
        if (root.data == x)
            return true;
        if (isNodePresent(root.left, x))
            return true;
        if (isNodePresent(root.right, x))
            return true;
        return false;
    }

    public static int largest(BinaryTreeNode<Integer> root) {// assuming all entries all positive
        if (root == null)
            return -1;
        int largestLeft = largest(root.left);
        int largestRight = largest(root.right);
        return Math.max(Math.max(largestLeft, largestRight), root.data);// comparing 3 integers
    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.data > x)
            count++;
        return count + countNodesGreaterThanX(root.left, x) + countNodesGreaterThanX(root.right, x);
    }

    public static int height(BinaryTreeNode<Integer> root) { //-1:null node
        if (root == null)
            return 0;
       // int height = 1;
        return 1+ Math.max(height(root.left), height(root.right));
    }

    public static int noOfLeaf(BinaryTreeNode<Integer> root) {
        if (root == null)
            return 0;
        if (root.left != null && root.right != null)
            return 1; // root itself is leaf
        return noOfLeaf(root.left) + noOfLeaf(root.right);
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null)
            return;
        if (k==0) {
            System.out.println(root.data);
        }
        printAtDepthK(root.left, k-1);
        printAtDepthK(root.right, k-1);
    }
    public static void changeToDepthK(BinaryTreeNode<Integer> root,int k) { //helper or general function
        if(root==null)
             return;
        root.data=k;
        changeToDepthK(root.left, k+1);
        changeToDepthK(root.right, k+1);
    }
    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
             changeToDepthK(root,0);
    }
    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
          if (root==null)
              return;
          if (root.left==null && root.right==null) //leaves node
              return;
          if (root.left==null){
              System.out.print(root.right.data+" ");
              printNodesWithoutSibling(root.right);
          }else if (root.right==null){
              System.out.print(root.left.data+" ");
              printNodesWithoutSibling(root.left);
          }else{// both children exist
              printNodesWithoutSibling(root.left);
              printNodesWithoutSibling(root.right);
          }
    }
    public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
        if (root==null)
            return null;
        if (root.left==null&root.right==null){ //root itself is a leave
            return null;
        }
       root.left= removeLeaves(root.left);
       root.right= removeLeaves(root.right);
        return root;
    }
    public static boolean isBalanced(BinaryTreeNode<Integer> root){// O(nlogn), worst case : O(n^2)
        if (root==null)
            return true;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if (Math.abs(leftHeight-rightHeight)>1)
            return false;
        // if we reach at this stage its mean root is balanced
        // now check balancedness for left tree and right tree
        boolean isLeftBalanced=isBalanced(root.left);
        boolean isRightBalanced=isBalanced(root.right);
        return isLeftBalanced && isRightBalanced;
    }
    public static BalancedBetter isBalancedBetter(BinaryTreeNode<Integer> root){
        // now we want to return 2 things together
        if (root==null){
            BalancedBetter ans=new BalancedBetter();
            ans.height=0;
            ans.isBalanced=true;
            return ans;
        }
       BalancedBetter leftOutput=isBalancedBetter(root.left)   ;
       BalancedBetter rightOutput=isBalancedBetter(root.right) ;
       boolean isBalanced=true;
       int height=1+Math.max(leftOutput.height, rightOutput.height);
       if (Math.abs(leftOutput.height- rightOutput.height)>1) {
           isBalanced=false;
       }
       if (!leftOutput.isBalanced||!rightOutput.isBalanced){
           isBalanced=false;
       }
        BalancedBetter ans=new BalancedBetter();
       ans.height=height;
       ans.isBalanced=isBalanced;
       return ans;

    }
    public static int diameter(BinaryTreeNode<Integer> root){
        if (root==null)
            return 0;
        //both side equal nodes vala tree
        int option1=height(root.left)+height(root.right);
        //ek hi side pe sare nodes
        int option2=diameter(root.left);
        int option3=diameter(root.right);
        return Math.max(Math.max(option1,option2),option3);
    }
    public static DiameterBetter diameterBetter(BinaryTreeNode<Integer> root) {
        if (root == null){
            DiameterBetter ans=new DiameterBetter();
            ans.height=0;
            ans.diameter=0;
            return ans;
        }
       DiameterBetter leftOutput=diameterBetter(root.left);
        DiameterBetter rightOutput=diameterBetter(root.right);
        // after this everything will take constant time
        int option1=leftOutput.height+rightOutput.height;
        int option2=leftOutput.diameter;
        int option3=rightOutput.diameter;
        DiameterBetter ans=new DiameterBetter();
        ans.height=1+Math.max(leftOutput.height,rightOutput.height);
        ans.diameter= Math.max(Math.max(option1,option2),option3);
            return ans;
    }
    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        // right child of every node become left and left become right
        //left-root-right  becomes  right-root-left
           if (root==null){
               return;
           }

               BinaryTreeNode<Integer> temp=root.left;
               root.left=root.right;
               root.right=temp;

           mirrorBinaryTree(root.left);
           mirrorBinaryTree(root.right);
    }
    public static void printInorderBinaryTree(BinaryTreeNode<Integer>root){
        if (root==null)
            return;
        printInorderBinaryTree(root.left);
        System.out.print(root.data+" ");
        printInorderBinaryTree(root.right);
    }
    public static void printPreOrderBinaryTree(BinaryTreeNode<Integer>root){
        if (root==null)
            return;
        System.out.print(root.data+" ");
        printPreOrderBinaryTree(root.left);
        printPreOrderBinaryTree(root.right);
    }
    public static void printPostOrderBinaryTree(BinaryTreeNode<Integer>root){
        if (root==null)
            return;
        printPostOrderBinaryTree(root.left);
        printPostOrderBinaryTree(root.right);
        System.out.print(root.data+" ");
    }
    public static BinaryTreeNode<Integer> buildPostOrderTreeHelper(int[] preOrder,int [] inOrder,int inOStart,int inOEnd,int preOStart,int preOEnd){
        if (inOStart>inOEnd)
            return null;
        int rootData=preOrder[preOStart];
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
        int rootInIndex=-1;//in inorder
        for (int i=inOStart;i<=inOEnd;i++){
            if (inOrder[i]==rootData) {
                rootInIndex= i ;
                break;
            }
        }
        //inorder ka left
        int leftInStart=inOStart;
        int leftInEnd=rootInIndex-1;
        //inorder ka right
        int rightInStart=rootInIndex+1;
        int rightInEnd=inOEnd;
        //preorder ka left
        int leftPreStart=preOStart+1;// 1st position will be for root
        int leftPreEnd=leftInEnd-leftInStart+leftPreStart; // write defn of in,pre on notebook and see carefully
        //preorder ka right
        int rightPreStart=leftPreEnd+1;
        int rightPreEnd =   preOEnd;

        root.left=buildPostOrderTreeHelper(preOrder,inOrder,leftInStart,leftInEnd,leftPreStart,leftPreEnd);
        root.right=buildPostOrderTreeHelper(preOrder,inOrder,rightInStart,rightInEnd,rightPreStart,rightPreEnd);

        return root;

    }
    public static BinaryTreeNode<Integer> buildPostOrderTree(int[] preOrder, int[] inOrder) {
        // assumption unique elets in both the array/ binary tree
        return buildPostOrderTreeHelper(preOrder,inOrder,0,inOrder.length-1,0,preOrder.length-1);
        }
    public static BinaryTreeNode<Integer> buildPreOrderTreeHelper(int[] postOrder,int [] inOrder,int inOStart,int inOEnd,int postOStart,int postOEnd){
        if (inOStart>inOEnd)
            return null;
        int rootData=postOrder[postOEnd];
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
        int rootInIndex=-1;//in inorder
        for (int i=inOStart;i<=inOEnd;i++){
            if (inOrder[i]==rootData) {
                rootInIndex= i ;
                break;
            }
        }
        //inorder ka left
        int leftInStart=inOStart;
        int leftInEnd=rootInIndex-1;
        //inorder ka right
        int rightInStart=rootInIndex+1;
        int rightInEnd=inOEnd;
        //preorder ka left
        int leftPostStart=postOStart;// 1st position will be for root
        int leftPostEnd=leftInEnd-leftInStart+leftPostStart; // write defn of in,pre on notebook and see carefully
        //preorder ka right
        int rightPostStart=leftPostEnd+1;
        int rightPostEnd =postOEnd-1;// rightInEnd-rightInStart+rightPostStart

        root.left=buildPreOrderTreeHelper(postOrder,inOrder,leftInStart,leftInEnd,leftPostStart,leftPostEnd);
        root.right=buildPreOrderTreeHelper(postOrder,inOrder,rightInStart,rightInEnd,rightPostStart,rightPostEnd);

        return root;

    }
    public static BinaryTreeNode<Integer> buildPreOrderTree(int[] postOrder, int[] inOrder) {
        // assumption unique elets in both the array/ binary tree
        return buildPreOrderTreeHelper(postOrder,inOrder,0,inOrder.length-1,0,postOrder.length-1);
    }
    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
            if(root==null)
                return;
        BinaryTreeNode<Integer> duplicate=new BinaryTreeNode<Integer>(root.data);
        BinaryTreeNode<Integer> temp=root.left;
        root.left=duplicate;
        duplicate.left=temp;
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
    }
    public static void printLevelWiseBinaryTree(BinaryTreeNode<Integer> root) {
        if (root==null)
            return;
        Queue<BinaryTreeNode<Integer>> pq=new LinkedList<>();//pending queue
        Queue<BinaryTreeNode<Integer>> cq=new LinkedList<>();//child queue
        pq.add(root);
        while (!pq.isEmpty()){
            BinaryTreeNode<Integer>temp  = pq.remove();
            System.out.print(root.data+" ");
            if (temp.left!=null)
               cq.add(temp.left);
            if (temp.right!=null)
               cq.add(temp.right);
           if (pq.isEmpty()) {
               pq = cq;
               cq=new LinkedList<>();
               System.out.println();
           }
        }
    }
    static Pair<Integer,Integer> ans=new Pair<>(Integer.MAX_VALUE,Integer.MIN_VALUE);
    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        // initially min=infinity,max=-infinity
        if (root==null)
            return ans;
        if (root.data<ans.first)
            ans.first=root.data;
        if (root.data> ans.second)
            ans.second=root.data;
        getMinAndMax(root.left);
        getMinAndMax(root.right);
        return ans;
    }
    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k,String arr) {
        if (root==null)
            return;
        arr=arr+root.data+"";
        if (root.data==k&&root.left==null&&root.right==null)
            System.out.println(arr);
        rootToLeafPathsSumToK(root.left,k-root.data,arr);
        rootToLeafPathsSumToK(root.right,k-root.data,arr);
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        rootToLeafPathsSumToK(root,k,"");
    }


    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        print(root,node,k);
    }

        private static int print(BinaryTreeNode<Integer> root, int node, int k)
        {
            //If tree is empty return -1
            if (root==null)
                return -1;

            int rootData=root.data;
            if (rootData==node)
            {
                printNodesAtDistanceK(root, k);
                return 0;// distance btween root and elt/node
            }

            int leftSubTreeDist=0,rightSubTreeDist=0;

            leftSubTreeDist=print(root.left,node,k);
            if (leftSubTreeDist!=-1)
            {
                if(leftSubTreeDist+1==k)
                {
                    System.out.println(rootData);
                }
                else
                {
                    rightSubTreeDist=k-(leftSubTreeDist+1)-1;
                    printNodesAtDistanceK(root.right, rightSubTreeDist);
                }
                return leftSubTreeDist+1;
            }

            rightSubTreeDist=print(root.right,node,k);
            if (rightSubTreeDist!=-1)
            {
                if(rightSubTreeDist+1==k)
                {
                    System.out.println(rootData);
                }
                else
                {
                    leftSubTreeDist=k-(rightSubTreeDist+1)-1;
                    printNodesAtDistanceK(root.left, leftSubTreeDist);
                }
                return rightSubTreeDist+1;
            }
            return -1;
        }

        private static void printNodesAtDistanceK(BinaryTreeNode<Integer> root, int k)
        {
            if (root==null || k<0)
                return;

            if (k == 0)
            {
                System.out.println(root.data);
                return;
            }

            printNodesAtDistanceK(root.left,k-1);
            printNodesAtDistanceK(root.right,k-1);
        }

    public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root,int sum) {
         if(root==null)
             return sum;// return the sum of all nodes greater than root
        sum=replaceWithLargerNodesSum(root.right,sum);
        sum+=root.data;
        root.data=sum;
       return replaceWithLargerNodesSum(root.left,sum);

    }
    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root){
        replaceWithLargerNodesSum(root,0);
    }





    public static void main(String[] args) {
//     BinaryTreeNode<Integer> root=new BinaryTreeNode<>(10);
//     BinaryTreeNode<Integer> node1=new BinaryTreeNode<>(20);
//     BinaryTreeNode<Integer> node2=new BinaryTreeNode<>(30);
//     root.left=node1;
//     root.right=node2;
        // Scanner s=new Scanner(System.in);
        // BinaryTreeNode<Integer> root=takeInput(s );
       // BinaryTreeNode<Integer> root = takeInputLevelWise();
        //printTree(root);
        //printLevelWise(root);
       // System.out.println(largest(root));
      //  printLevelWise(removeLeaves(root));
        //printInorderBinaryTree(root);
      //  printLevelWise(buildPostOrderTree(new int[]{4,2,5,1,3,7},new int[]{1,2,4,5,3,7}));

    }
        }





