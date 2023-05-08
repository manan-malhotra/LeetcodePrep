// https://leetcode.com/problems/single-number/description/

// Given a non-empty array of integers nums, every element appears twice except for one. 
// Find that single one.

// You must implement a solution with a linear runtime complexity and use only constant extra space.

// Tags: XOR Bit Manipulation

package Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int xor = 0;
        for(int i:nums){
            xor^=i;
        }
        return xor;
    }
}
