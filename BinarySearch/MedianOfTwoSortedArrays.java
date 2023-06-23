// https://leetcode.com/problems/median-of-two-sorted-arrays/description/

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


package BinarySearch;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = {1,7,10,11};
        int[] num2 = {2,3,4,8,9,14};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m= nums2.length;
        if(n==0 && m==0) return 0.0;
        if(n>m) return findMedianSortedArrays(nums2, nums1);
        if(n==0){
            if(m%2==0){
                return (nums2[m/2]+nums2[(m-1)/2])/2.0;
            }
            return nums2[m/2];
        }
        
        int start = 0;
        int end = n;
        int total = n+m;

        while(start<=end){
            int mid1 = start + (end-start)/2;
            int mid2 = (total+1)/2 - mid1;
            int left1 = Integer.MIN_VALUE;
            int left2 = Integer.MIN_VALUE;
            int right1 = Integer.MAX_VALUE;
            int right2 = Integer.MAX_VALUE;
            if(mid1!=0) left1 = nums1[mid1-1];
            if(mid2!=0) left2 = nums2[mid2-1];
            if(mid1!=n) right1 = nums1[mid1];
            if(mid2!=m) right2 = nums2[mid2];

            if(left1<=right2 && left2<=right1){
                if(total%2==0){
                    return (Math.max(left1, left2)+Math.min(right1, right2))/2.0;
                }
                return Math.max(left1, left2);
            }else if(left1>right2){
                end = mid1-1;
            }else{
                start = mid1+1;
            }

        }
        return 0.0;
    }
    
}
