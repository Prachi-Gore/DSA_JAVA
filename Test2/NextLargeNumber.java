package com.project.Test2;

import org.w3c.dom.Node;
class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}
public class NextLargeNumber {

    public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
            LinkedListNode<Integer> temp;
            LinkedListNode<Integer> prev =null;
            LinkedListNode<Integer> curr=head;
            while(curr!=null){
                temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            LinkedListNode<Integer> tem=prev;
            int extra=0;
            LinkedListNode<Integer> a= new LinkedListNode<Integer>(1);
            while(tem!=null){
                if(tem.data==9){
                    tem.data=0;
                    extra=1;
                    if(tem.next==null){
                        tem.next=a;
                    }
                }else{
                    if(extra==1){
                        int d=tem.data+1;
                        if(d==10){
                            tem.data=0;
                            extra=1;
                        }else{
                            extra=0;
                        }
                    }else{
                        tem.data=tem.data+1;
                        break;
                    }}
                tem=tem.next;
            }
            LinkedListNode<Integer> temp1;
            LinkedListNode<Integer> prev1 =null;
            LinkedListNode<Integer> curr1=prev;
            while(curr1!=null){
                temp1=curr1.next;
                curr1.next=prev1;
                prev1=curr1;
                curr1=temp1;
            }
            return prev1;

        }
}
