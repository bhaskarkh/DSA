package org.bhaskar.linkedlist;

import javax.swing.*;

public class MyLinkedList {
    Node head;
    Node tail;
    int length;

    public MyLinkedList(int value) {
        this.head = new Node(value);
        this.tail = new Node(value);
        this.length = 1;
    }

    public void printLinkedList() {
        System.out.println("head equals: " + head.getValue());
        System.out.println("tail equals: " + tail.getValue());
        System.out.println("length equals: " + length);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null)
                System.out.print("-->");
            temp = temp.next;
        }
        System.out.println("");
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            temp = newNode;
            tail = temp;
        }
        length += 1;
    }
    public Node removeLast(){
        Node temp=head;
        Node pre=head;
        while (temp.next!=null)
        {
            pre=temp;
            temp=temp.next;

        }
        tail=pre;
        tail.next=null;
        length-=1;
        return temp;
    }
    public Node removeFirst(){
       if(head==null)
           return null;
       else {
           Node temp=head;
           head=head.next;
           temp.next=null;
           length-=1;
           return temp;
       }

    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
