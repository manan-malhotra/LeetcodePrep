// https://leetcode.com/problems/squares-of-a-sorted-array/description/

// Given an integer array nums sorted in non-decreasing order, 
// return an array of the squares of each number sorted in non-decreasing order.

// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].

// Tags: Sorting, Two Pointers, Arrays

package Arrays;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-7,-3,2,4,11};
        System.out.println(Arrays.toString(sortedSquares(arr)));
    }
    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        int index = nums.length- 1;
        int result[] = new int [nums.length];
        while(left<=right)
        { // index from the right to left
            if(Math.abs(nums[left])>Math.abs(nums[right])) // compare abs of -ve with rightmost
            {
                result[index] = nums[left] * nums[left];
                left++;
            }
            else
            {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        return result;
    }
    public static int[] sortedSquaresSorting(int[] nums) { // nlogn
        for(int i = 0;i<nums.length;i++)
        {
            nums[i] *= nums[i]; // Create a new Arrays with squares of initial array
        }
        Arrays.sort(nums); // Sort the array using inbuild
        return nums;
    }
}
