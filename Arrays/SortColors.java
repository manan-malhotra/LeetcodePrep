// https://leetcode.com/problems/sort-colors/description/
// Given an array nums with n objects colored red, white, or blue, sort them in-place so 
// that objects of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.

// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// Tags: Two pointer
package Arrays;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int len = nums.length;
        if(len < 2) return;
 
        int left = 0;
        int right = len - 1;
        int current = 0;
        while(current <= right) {
            if(nums[current] == 0){
                swap(nums, left, current);
                left++;
                current++;
            }
            else if(nums[current] == 1) {
                current++;
            }
            else {
                swap(nums, right, current);
                right--;
            }
        }
    }
    public static void swap(int[] arr ,int i, int j){
        int temp = arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
}
