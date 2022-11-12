package com.project.LinkedList;



import java.util.ArrayList;
import java.util.Scanner;


public class LL {
 // create LL by taking input(data) from user until input!=-1 eg., 3->1->5
 // keep return type Node<>(head) so that we can print entire list
  public static Node<Integer> takeInput(){// O(N(N-2))
      Node<Integer> head=null;
      Scanner s=new Scanner(System.in);
    int data= s.nextInt();
    while (data!=-1){
        Node<Integer> node=new Node<Integer>(data) ;

        if (head==null){
            head=node;
        }else {
            Node<Integer> temp=head;
            while (temp.next!=null){
                temp=temp.next;// temp node to find last node
            }
            temp.next=node;
        }
        data=s.nextInt();

    }
    return head;
  }
    public static Node<Integer> takeInputBetter(){ //O(N)
        Node<Integer> head=null; // to keep track of first node
        Node<Integer> tail=null; // to keep track of last node
        Scanner s=new Scanner(System.in);
        int data= s.nextInt();
        while (data!=-1){
            Node<Integer> node=new Node<Integer>(data) ;

            if (head==null){
                head=node;
                tail=node;
            }else {
                tail.next=node;
                tail=tail.next; // tail=node //we are updating tail at each time
            }
            data=s.nextInt();

        }

        return head;
    }

  public static void print(Node<Integer> n) {
      while (n != null) {
          System.out.print(n.data + "->");
          n = n.next;
      }
  }
    public static void printIthNode(Node<Integer> head, int i){
      int count=0;
      Node<Integer> temp=head;
      while (count<=i & temp!=null) {
          if (count == i) {
              System.out.println(temp.data);
              return;
          } else {
              count++;
              temp = temp.next;
          }
      }
      System.out.println(-1); //count>i


    }
    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
      Node<Integer> temp=head;
      if (pos==0){
          temp=temp.next;
          return temp;
      }
      int i=0;
      while(i<pos-1){
          i++;
          temp=temp.next;
      }
      if(temp.next.next!=null) {
          Node<Integer> t= temp.next.next;
          temp.next = temp.next.next;
          t=null;
      }
      else
          temp.next=null;
      return head;
    }
    public static int length(Node<Integer> head){
      if(head==null)
          return 0;
      int count=0;
      while (head!=null) {
          count++;
          head = head.next;
      }
          return count;


    }
    public static Node<Integer> midPoint(Node<Integer> head) {
        if(head==null)
            return head;
        Node<Integer> slow=head;
        Node<Integer> fast=head;

        while (fast.next!=null & fast.next.next!=null) { // first condition for odd second for even// if fist cond false then overall false
            slow = slow.next;   // will not second cond if it checks null point exception error will raise
            fast = fast.next.next;
        }
        return slow;

    }
    public static Node<Integer> deleteNodeRec(Node<Integer> head, int pos) {
      if(head==null) // pos>=length // index start from 0
            return head;
      if (pos==0)
          return head.next;
      head.next=deleteNodeRec(head.next,pos-1);
      return head;

    }
    public static void printReverseLinkedListRec(Node<Integer> head) {
      if (head==null)
          return ;
      printReverseLinkedListRec(head.next);
      System.out.print(head.data+" ");
  }
    public static Node<Integer> reverseLinkedListRec(Node<Integer> head) { // Anuj bhaiya
        if (head==null || head.next==null)
            return head;
        Node<Integer> newHead= reverseLinkedListRec(head.next);
        head.next.next=head;// whenever we call recursion head get updated and thats why this also
        head.next=null;
        return newHead;

  }
    public static Node<Integer> reverse_I(Node<Integer> head){
        Node<Integer> previous=null;
        Node<Integer> next=null;
        Node<Integer> current=head;
        while (current!=null) {
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
       return previous;
  }
    public static int findNode(Node<Integer> head, int n) {
      int count=0;
      while (head!=null){
          if (head.data==n)
              return count;
          head=head.next;
          count++;
      }
      return -1;

    }
    public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
        if(n==0 || head==null)
            return head;
      Node<Integer> temp=head.next;
      int length=1;
      while(temp.next!=null){
          length++;
          temp=temp.next;
      }
      length=length+1;
      Node<Integer> tail=temp;
      int pos=1; // how many node we have to travel
       temp=head;
      while (pos<length-n){
          temp=temp.next;
          pos++;
      }
      Node<Integer> newHead=temp.next;
      temp.next=null;
      tail.next=head;
      return  newHead;

    }
    // list is sorted
    public static Node<Integer> removeDuplicates(Node<Integer> head) {
       if (head==null )
           return head;
        Node<Integer> t1=head;
        Node<Integer> t2=head.next;
        while(t2!=null) {
            if (t1.data.equals(t2.data)) {
                t2 = t2.next;
            } else {    // see carefully t2 will points on unique elts only
              //  t1.next = t2;
                t1 = t2;
            }

        }
        t1.next=null;// 1 1 1 2 3 3 , 1 2 2 2 3 3 4 5
        return head;
    }
    public static boolean isPalindrome(Node<Integer> head) {
      ArrayList<Integer> arr=new ArrayList<>();
       while (head!=null){
           arr.add(head.data);
           head=head.next;
       }
       int start=0;int end=arr.size()-1;
       while (start<end){
           if (arr.get(start)!=arr.get(end)){
               return false;
           }else{
               start++;
               end--;
           }
       }
        return true;
  }




    public static void main(String[] args) {
  // print(takeInput());
    //    print(takeInputBetter());
    }
}
