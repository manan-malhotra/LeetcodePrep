// https://leetcode.com/problems/maximum-subarray/
// Given an integer array nums, find the subarray with the largest sum, and return its sum.
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

// Tags:KADANE Algo

package Arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int len=nums.length;
        int maxsofar=Integer.MIN_VALUE;
        int maxendinguptohere=0;
        for(int i=0;i<len;i++)
        {
            maxendinguptohere+=nums[i];
            if(maxendinguptohere>maxsofar)
            maxsofar=maxendinguptohere;
            if(maxendinguptohere<0)
            maxendinguptohere=0;
        }
        return maxsofar;
        
    }
}
