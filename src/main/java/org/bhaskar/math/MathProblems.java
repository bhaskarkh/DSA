package org.bhaskar.math;

public class MathProblems {
    public static Boolean isPalindromeNumber(int n)
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
}
