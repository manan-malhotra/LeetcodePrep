// https://leetcode.com/problems/next-permutation/description/
// A permutation of an array of integers is an arrangement of its members into a 
// sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: 
// [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically 
// greater permutation of its integer. 
// More formally, if all the permutations of the array are sorted in one container 
// according to their lexicographical order, then the next permutation of that
//  array is the permutation that follows it in the sorted container. 
// If such arrangement is not possible, the array must be rearranged as the 
// lowest possible order (i.e., sorted in ascending order).

// Tags: Array

package Arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {0,1,2,5,3,3,0};
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    public static int[] nextPermutation(int[] nums){
        // pivot is the element just before the non-increasing (weakly decreasing) suffix
        int pivot = findPivot(nums)-1;
        // paritions nums into [prefix pivot suffix]
        if(pivot!=-1){
            int nextGreaterElement = findNext(nums,pivot);
            // next prefix must exist because pivot < suffix[0], otherwise pivot would be part of suffix
            swap(nums,pivot,nextGreaterElement);
            // this minimizes the change in prefix
        }
        reverseSuffix(nums,pivot+1);
        // reverses the whole list if there was no pivot
        return nums;
    }
    /* Reverse numbers starting from an index till the end. */
    private static void reverseSuffix(int[] nums, int start) {
        int end = nums.length-1;
        while(start<end){
            swap(nums, start++, end--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }

    private static int findNext(int[] nums, int pivot) {
        int threshold = nums[pivot];
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>threshold) return i;
        }
        return 0;
    }
    /* Find the last element which is a peak.
    * In case there are multiple equal peaks, return the first of those.
    * @return first index of last peak
    */
    private static int findPivot(int[] nums) {
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                return i;
            }
        }
        return 0;
    }
}
