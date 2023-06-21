// https://leetcode.com/problems/split-array-largest-sum/description/

// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

// Return the minimized largest sum of the split.

// A subarray is a contiguous part of the array.

// Example 1:

// Input: nums = [7,2,5,10,8], k = 2
// Output: 18
// Explanation: There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

package BinarySearch;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
    public static int splitArray(int[] arr, int k){
        int start = Integer.MIN_VALUE;
        int end = 0;

        for(int i : arr){
            if(i>start) start = i;
            end +=i;
        }

        while(start<end){
            int mid = start + (end-start)/2;
            int splits = 1;
            int currSum = 0;
            for (int i : arr) {
                if(currSum+i > mid){
                    currSum = i;
                    splits++;
                }else{
                    currSum+=i;
                }
            }
            if(splits>k){
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return end;
    }
}
