package org.bhaskar.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums={-1,0,3,5,9,12};
        System.out.println(search(nums,13));
    }
    public static int search(int[] arr, int x) {
        int l=0;
        int r= arr.length-1;
        while (l <= r) {
            int mid = (l + r) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x) {
                return mid;

                // If element is smaller than mid, then
                // it can only be present in left subarray
                // so we decrease our r pointer to mid - 1
            } else if (arr[mid] > x) {
                r = mid - 1;

                // Else the element can only be present
                // in right subarray
                // so we increase our l pointer to mid + 1
            } else {
                l = mid + 1;
            }
        }

        // We reach here when element is not present
        //  in array
        return -1;
    }
}
