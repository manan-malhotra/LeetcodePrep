// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
// Example 1:

// Input: nums = [3,4,5,1,2]
// Output: 1
// Explanation: The original array was [1,2,3,4,5] rotated 3 times.

package BinarySearch;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));
    }

    private static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;     
        while(start<end){
            int mid = start + (end - start)/2;
            if(nums[mid]<nums[end]) end = mid;
            else start = mid+1;
        }
        return nums[end];
    }
    
}
