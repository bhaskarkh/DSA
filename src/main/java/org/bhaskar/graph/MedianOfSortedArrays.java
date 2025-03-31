package org.bhaskar.graph;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        int[] nums1=new int[]{1,2};
        int[] nums2=new int[]{3,4};
        //double medianValue=findMedianSortedArrays(nums1,nums2);
       // System.out.println(medianValue);
        String str="01001";
        int x=maxScore(str);
        System.out.println(x);
    }
    public static int maxScore(String s) {
        int res=0;
        int n=s.length();
        if(n==2){
            if(s.charAt(0)=='0')
                res++;
            if(s.charAt(1)=='1')
                res++;
            return res;
        }
        for(int i=1;i<n;i++)
        {
            int tempRes=0;
            String left=s.substring(0,i);
            String right=s.substring(i,n);

            for(int j=0;j<left.length();j++)
            {
                if(left.charAt(j)=='0') tempRes++;
            }
            for(int j=0;j<right.length();j++)
            {
                if(right.charAt(j)=='1') tempRes++;
            }
            res=Math.max(tempRes,res);
        }
        return res;

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] nums3=new int[m+n];
        int k=0;
        int i=0,j=0;
        while(i<m && j<n)
        {
            int x=nums1[i];
            int y=nums2[j];
            if(x>y)
            {
                nums3[k]=y;
                j++;
            }else{
                nums3[k]=x;
                i++;
            }
            k++;
        }
        while(i<m){
            nums3[k]=nums1[i];
            k++;
            i++;
        }
        while(j<n){
            nums3[k]=nums2[j];
            k++;
            j++;
        }
        int num3_index=nums3.length;
        double median;
        if (num3_index% 2 == 0)
            median = ((double)nums3[num3_index/2] + (double)nums3[num3_index/2 - 1])/2;
        else
            median = (double) nums3[num3_index/2];

        return median;
    }
}
