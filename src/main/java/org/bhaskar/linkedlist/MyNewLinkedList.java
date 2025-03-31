package org.bhaskar.linkedlist;

import java.util.Optional;

public class MyNewLinkedList {
    private Node head;
    private Node tail;
    private int length;

    MyNewLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;

    }

    private Node getHead() {
        return head;
    }

    private Node getTail() {
        return tail;
    }

    private int getLength() {
        return length;
    }

    public void printDetails() {
        System.out.println("");

        if (head != null) System.out.print(" head value: " + head.value);

        if (tail != null) System.out.print(" tail value: " + tail.value);

        System.out.print(" length value: " + length);
        System.out.println("");
    }

    public void printLinkedList() {
        System.out.println("");
        if (length == 0) System.out.println("Empty Linked List");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            temp = temp.next;
            if (temp != null) System.out.print("-->");
        }
        printDetails();
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            tail = temp.next;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node before = null;
        while (temp.next != null) {
            before = temp;
            temp = temp.next;
        }
        before.next = null;
        tail = before;
        length--;
        System.out.println(temp.value + " removed from last");
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        System.out.println(temp.value + " removed from first");
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index > length) return null;

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int value, int index) {
        return true;
    }

    //print,append,removelast,removefirst,get,set,insert,remove,reverse
    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }
}
