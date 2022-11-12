package com.project.BST;

import com.project.BinaryTree.BinaryTreeNode;

public class BinarySearchTreeImplementation {
    BinaryTreeNode<Integer>root;

        public BinaryTreeNode<Integer> insert(int data,BinaryTreeNode<Integer> root) {
            if(root==null){
                BinaryTreeNode<Integer> newNode=new BinaryTreeNode<>(data);
                return newNode;
            }
            if (root.data<data){
               root.right= insert(data,root.right);
            }else
               root.left= insert(data,root.left);
            return root;
        }
        public void insert(int data){
            root=insert(data,root);
        }
    public BinaryTreeNode<Integer> remove(int data,BinaryTreeNode<Integer>root) {
            if (root==null)
                return null;
            if (data<root.data) {
                root.left = remove(data, root.left);
                return root;
            }
            else if (root.data<data) {
                root.right = remove(data, root.right);
                return root;
            }
            else {
                if (root.left==null && root.right==null){//leave node
                    return  null;
                }
                else if (root.left==null){
                    return root.right;
                }
                else if (root.right==null){
                    return root.left;
                }
                else{
                    BinaryTreeNode<Integer>minNode=root.right;
                    while (minNode.left!=null){
                        minNode=minNode.left;
                    }
                    root.data=minNode.data;
                    root.right=remove(minNode.data, root.right);
                    return root;
                }
            }
        }
    public void remove(int data) {
          root= remove(data,root);
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
    public void printTree() {
            printTree(root);
        }
public boolean searchHelper(int data, BinaryTreeNode<Integer>root){
                if (root==null)
                        return false;
                if (root.data==data)
                        return true;
                else if (data<root.data)
                    return searchHelper(data,root.left);
                else
                    return searchHelper(data,root.right);
}

        public boolean search(int data) {
            return searchHelper(data,root);
        }
}

