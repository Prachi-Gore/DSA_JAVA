package com.project.BinaryTree;

public class BinaryTreeNode<T> {
   public T data;
   public BinaryTreeNode<T> left;
   public BinaryTreeNode<T> right;
   public BinaryTreeNode(T data){
      this.data=data;
      this.left=null;
      this.right=null;

   }
}

