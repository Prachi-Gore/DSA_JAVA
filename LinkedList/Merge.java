package com.project.LinkedList;

public class Merge {
    public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1,Node<Integer> head2) {
           Node<Integer> head=null;

          //  if(head1==null && head2==null)
          //      return head;
            if(head1==null)
                return head2;
            if(head2==null)
                return head1;
            if (head1.data<= head2.data){ // to assign head correctly by comparing first elt of both the list
                head=head1;   // Dinesh viryani // CN
                //  tail=head1;
                head1=head1.next;
            }else{
                head=head2;
                //  tail=head2;
                head2=head2.next;
            }
           Node<Integer> tail=head;
            while (head1 !=null && head2!=null){
                if (head1.data<= head2.data){
                    // head1.next=head2;
                    tail.next=head1;
                    tail=head1;
                    head1=head1.next;
                }else {
                    // head2.next=head1;
                    tail.next=head2;
                    tail=head2;
                    head2=head2.next;

                }
                //tail=tail.next;
            }
            if(head1==null)
                tail.next=head2;
            if(head2==null)
                tail.next=head1;

            return head;

        }
    }

