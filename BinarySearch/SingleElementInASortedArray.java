// https://leetcode.com/problems/single-element-in-a-sorted-array/description/
// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

// Return the single element that appears only once.

// Your solution must run in O(log n) time and O(1) space.

// Example 1:

// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2

package BinarySearch;

public class SingleElementInASortedArray {

    public static void main(String[] args) {
        int[] nums= {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }

    private static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] != nums[mid + 1]) end = mid;
            else start = mid + 2;
        }
        return start;
    }
    
}
