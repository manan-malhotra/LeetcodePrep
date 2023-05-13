// https://leetcode.com/problems/longest-consecutive-sequence/description/
// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.

// Tags: Sort, Array, Hash Set
package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = new int[]{0,3,7,2,5,8,4,6,0,-1,-1,1};
        System.out.println(longestConsecutiveHashSet(arr));
        System.out.println(longestConsecutiveSorting(arr));
    }

    public static int longestConsecutiveHashSet(int[] nums) {
        Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num: nums) {
            if (!hashSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                hashSet.remove(num);
                while (hashSet.contains(currentNum + 1)) {
                    hashSet.remove(num+1);
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    } 
    
    public static int longestConsecutiveSorting(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1]) continue;
            if (nums[i] - nums[i-1] == 1) count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }
        return Math.max(max, count);
    }
    
}
