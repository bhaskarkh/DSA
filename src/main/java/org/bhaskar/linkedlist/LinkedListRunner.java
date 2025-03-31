package org.bhaskar.linkedlist;

public class LinkedListRunner {
    public static void main(String[] args) {
        //MyLinkedList myLinkedList = new MyLinkedList(1);
        MyNewLinkedList myNewLinkedList = new MyNewLinkedList(1);
       // myLinkedList.append(2);
        /*myLinkedList.append(3);
        myLinkedList.printLinkedList();
        myLinkedList.append(4);
        myLinkedList.printLinkedList();
        myLinkedList.removeLast();
        myLinkedList.printLinkedList();*/
        //myLinkedList.removeLast();
        //myLinkedList.printLinkedList();
        myNewLinkedList.append(2);
        myNewLinkedList.append(3);
        myNewLinkedList.append(4);
        myNewLinkedList.printLinkedList();
        System.out.println("value at index 1 is "+myNewLinkedList.get(1).getValue());
        System.out.println("value at index 6 is "+myNewLinkedList.get(6));
        myNewLinkedList.removeLast();
        myNewLinkedList.printLinkedList();
        System.out.println("value at index 2 is "+myNewLinkedList.get(2).getValue());
        myNewLinkedList.removeFirst();
        myNewLinkedList.printLinkedList();
        myNewLinkedList.removeLast();
        myNewLinkedList.printLinkedList();
        myNewLinkedList.removeFirst();
        myNewLinkedList.printLinkedList();
        myNewLinkedList.removeFirst();
        myNewLinkedList.removeLast();


    }
}
