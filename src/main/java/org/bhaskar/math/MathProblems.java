package org.bhaskar.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathProblems {
    /**
     *
     * Questions:
     * 1. {@literal Palindrome number check1}
     */
    public  Boolean isPalindromeNumber(int n)
    {
        int rev=0;
        int temp=n;
        while(temp!=0)
        {
            int x=temp%10;
            rev=rev*10+x;
            temp=temp/10;
        }
        return rev==n;
    }
    public  List<Integer> getAllDivisorOfNumber(int n)
    {
        return IntStream.range(1,n+1).boxed().filter(x->n%x==0).collect(Collectors.toList());
    }

    public List<Integer> getAllDivisorOfNumber2(int n) {
        List<Integer> list = new ArrayList<>();
        int i;
        for (i = 1; i*i <=n; i++) {
            if (n % i == 0) list.add(i);
        }
        while(i > 1) {
            i--;
            if (i!=(n/i) &&n % i == 0) list.add(n / i);
        }
        return list;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Test.ListNode l1=new Test.ListNode(2,new Test.ListNode(4,new Test.ListNode(3)));
        Test.ListNode l2=new Test.ListNode(5,new Test.ListNode(6,new Test.ListNode(4)));
        Test.ListNode x=addTwoNumbers(l1,l2);
        while (x!=null){
            System.out.println(x.val);
            x=x.next;
        }
    }
    public static Test.ListNode addTwoNumbers(Test.ListNode l1, Test.ListNode l2) {
        Test.ListNode l3=new Test.ListNode(0);
        //Test.ListNode l3=head;
        int carryNumber=0;
        while (l1!=null ||l2!=null)
        {
            int l1_value=(l1!=null)?l1.val:0;
            int l2_value=(l2!=null)?l2.val:0;
            int sumValue=l1_value+l2_value+carryNumber;
            carryNumber=sumValue/10;
            int digit=sumValue%10;
            Test.ListNode listNode=new Test.ListNode(digit);
            l3.next=listNode;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            l3=l3.next;
        }
        if(carryNumber>0){
            Test.ListNode tempNode=new Test.ListNode(carryNumber);
            l3.next=tempNode;
            l3=l3.next;

        }
        return l3.next;
    }

}
