// https://leetcode.com/problems/contains-duplicate/

// Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.

// Tags: Arrays, Hashsets

package Arrays;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,5};
        System.out.println(containsDuplicate(nums));
        
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); //Create a new Hashset
        for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) { // If hashset already has that int (i), Duplicate Exists
                    return true; // return true as duplicate is present
                }
                set.add(nums[i]); // else add it to the hashset
        }
        return false; // If there isnt any duplicate return false
    }
}
