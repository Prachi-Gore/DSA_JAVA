package com.project.Test2;

import com.project.LinkedList.Node;

public class Delete {
    public static void deleteAlternateNodes(Node<Integer> head) {
        //Your code goes here
        while(head.next!=null){
            if(head.next.next!=null){
                head.next=head.next.next;
                head=head.next;
            }else{
                head.next=null;
            }
        }
    }
}
