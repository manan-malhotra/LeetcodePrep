// https://leetcode.com/problems/3sum-closest/description/

// Given an integer array nums of length n and an integer target, 
// find three integers in nums such that the sum is closest to target.
// Return the sum of the three integers.

// You may assume that each input would have exactly one solution.
// Tags: Two Pointer
package Arrays;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,2,1,8};
        int target = 3;
        System.out.println(threeSumClosest(arr, target));
    }
    
    public static int threeSumClosest(int[] nums, int target) {
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int aPtr = i+1;
            int bPtr = nums.length-1;
            while(aPtr<bPtr){
                int sum = nums[i]+nums[aPtr]+nums[bPtr];
                if(sum<target){
                    aPtr++;
                }else if(sum>target){
                    bPtr--;
                }else{
                    return sum;
                }
                int diff = Math.abs(sum-target);
                if(diff<minDiff){
                    minDiff=diff;
                    closest=sum;
                }
            }
            
        }
        return closest;
    }

}
