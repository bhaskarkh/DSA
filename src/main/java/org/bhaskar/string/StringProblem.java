package org.bhaskar.string;

import java.util.Stack;

public class StringProblem {
    // https://leetcode.com/problems/reverse-words-in-a-string/description/
    //Reverse Words in a String
    //Example 1:
    //Input: s = "the sky is blue"
    //Output: "blue is sky the"

    //Example 2:
    //Input: s = "  hello world  "
    //Output: "world hello"
    //Explanation: Your reversed string should not contain leading or trailing spaces.

    //Example 3:
    //Input: s = "a good   example"
    //Output: "example good a"
    //Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

    public String reverseWord(String str){

        return "";
    }

    public int compress(char[] chars) {
        int start=0;
        int index=0;

        while(start<chars.length){
            int end =start;
            while(end < chars.length && (chars[start] == chars[end]))
            {
                end++;
            }
            int count = end - start;

            chars[index++]=chars[start];
            if(count>=2){
                char[] freq= Integer.toString(count).toCharArray();
                for(char c: freq){
                    chars[index++]=c;
                }
            }
            start=end;


        }
        return index;
    }

    public boolean isValidParentheses(String str){
        if(str == null || str.isBlank()|| str.length()<2 || str.length()%2!=0) return false;
        Stack<Character> stack =new Stack<>();
        char[] charArray=str.toCharArray();
        for(char c:charArray){
            if(c=='(' || c=='{' || c=='[') stack.push(c);
            else if(c==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }
            else if(c=='}' && !stack.isEmpty() && stack.peek()=='{'){
                stack.pop();
            }
            else if(c==']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
            }else{
                return false;
            }
        }
        if(stack.isEmpty()) return true;

        return false;
    }
}
