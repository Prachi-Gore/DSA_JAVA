package com.project.Stack;

public class StackUsingLL {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private  Node head;
    int size;

    public StackUsingLL() {
            head=null;
            size=0;
        }
        public int getSize() {
            return size;
        }

        public boolean isEmpty() {
            return size==0;
        }

        public void push(int element) {
            Node newNode = new Node(element);
            newNode.next = head;
            head = newNode;
            size++;
        }

            public int pop() {
                if(size==0){
                    return -1;
                }
                int tempData = head.data;
                head=head.next;
                size--;
                return tempData;

            }

            public int top() {
                if(size==0)
                    return -1;
                return head.data;
            }
}
