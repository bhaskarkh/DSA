package org.bhaskar.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {

        String s="wordgoodgoodgoodbestword";
        String[] strArry={"word","good","best","good"};
       // findSubstring(s,strArry).forEach(System.out::println);

        ListNode l1=new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2=new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode x=addTwoNumbers(l1,l2);
        while (x!=null){
            System.out.println(x.val);
            x=x.next;
        }



    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexList=new ArrayList<>();

        int word_length=words[0].length();
        int array_length=words.length;
        int substring_length=word_length*array_length;
        if(s.length()<substring_length) return indexList;
        int left_ptr=0;
        int right_ptr=substring_length;
        String sub_str="";
        while(right_ptr<=s.length())
        {
            sub_str="";
            sub_str=s.substring(left_ptr,right_ptr);
            insertIndexIfCorrectSubstring(sub_str,word_length,words,indexList,left_ptr);
            right_ptr++;
            left_ptr++;
        }
        return indexList;
    }
    public static void insertIndexIfCorrectSubstring(String sub_str, int word_length, String[] words, List<Integer> indexList, int left_ptr)
    {
        Map<String,Integer> wordMap=new HashMap<>();
        for(String str:words)
        {
            if(wordMap.containsKey(str))
            {
                wordMap.put(str,wordMap.get(str)+1);
            }
            else
            {
                wordMap.put(str,1);
            }
        }
        boolean flag=true;
        for(int i=0,j=word_length;i<=sub_str.length()-word_length && j<=sub_str.length();i=i+word_length,j=j+word_length)
        {
            String str1=sub_str.substring(i,j);


            if(!wordMap.containsKey(str1)) {
                flag = false;
                return;
            }
            else
                wordMap.put(str1,wordMap.get(str1)-1);
        }

        for(Map.Entry<String,Integer> keySet:wordMap.entrySet())
        {
            if(keySet.getValue()!=0) {
                flag = false;
                return;
            }
        }
        if(flag)
        indexList.add(left_ptr);
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
   /**
    * 243
      564
    */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode l3=head;
        int carryNumber=0;
        while (l1!=null ||l2!=null)
        {
            int l1_value=(l1!=null)?l1.val:0;
            int l2_value=(l2!=null)?l2.val:0;
            int sumValue=l1_value+l2_value+carryNumber;
            carryNumber=sumValue/10;
            int digit=sumValue%10;
            ListNode listNode=new ListNode(digit);
            l3.next=listNode;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            l3=l3.next;
        }
        if(carryNumber>0){
            ListNode tempNode=new ListNode(carryNumber);
            l3.next=tempNode;
            l3=l3.next;

        }
        return head.next;
    }

}
