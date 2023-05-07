// https://leetcode.com/problems/two-sum/description/

// Given an array of integers nums and an integer target, return indices of the two numbers 
// such that they add up to target.

// You may assume that each input would have exactly one solution, 
// and you may not use the same element twice.

// You can return the answer in any order.

// Tags: HashMap



package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,7,11,15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSumBrute(nums, target)));

        
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) { // If map already has the diff return index of diff and i
                return new int[] { prevMap.get(diff), i };
            }

            prevMap.put(num, i); // Else add it in the hashmap
        }

        return new int[] {};
    }
    public static int[] twoSumBrute(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){ // Basic n^2 Approach
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }

}
