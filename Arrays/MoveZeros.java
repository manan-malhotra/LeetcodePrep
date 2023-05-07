// https://leetcode.com/problems/move-zeroes/

// Given an integer array nums, move all 0's to the end of it 
// while maintaining the relative order of the non-zero elements.

// Note that you must do this in-place without making a copy of the array.

// Tags: Array, Two Pointers

package Arrays;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{2,0,1,4,2,0,0,11,22,3};
        // op 1,4,2,11,22,3,0,0,0
        System.out.println(Arrays.toString(nums));
        moveZerosTwoPointer(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        
        int currNonZero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[currNonZero++]= nums[i];
            }
        }
        for(int j=currNonZero;j<nums.length;j++){
            nums[j]=0;
        }
        
    }
    public static void moveZerosTwoPointer(int[] nums){
        int i,j;
        for(i=0,j=0;i<nums.length;){
            if(nums[i]==0) i++;
            else{
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }
        }  
    }
    public static void moveZeroesSwapping(int[] nums) { // Swap i with gap of numberOfZeros so far
        int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }
}
