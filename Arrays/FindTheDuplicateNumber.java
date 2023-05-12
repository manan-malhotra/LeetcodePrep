// https://leetcode.com/problems/find-the-duplicate-number/description/
/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.
 */
// All the integers in nums appear only once except for precisely one integer which appears two or more times.
// Tags: Count, Hashing, Hashset, Cycle Sort, Pointers, Fast and slow pointers, Linkedlist
package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(findDuplicate_2loops(nums));
        System.out.println(findDuplicateArrayFrequency(nums));
        System.out.println(findDuplicateHashset(nums));
        System.out.println(findDuplicateSort(nums));
        System.out.println(findDuplicateFastSlowPointer(nums));
        System.out.println(findDuplicateCycleSort(nums));
        System.out.println(findDuplicateMarkVisited(nums));
    }
    /*
    The key is to understand how to treat the input array as a linked list.
    Take the array [1,3,4,2] as an example, the index of this array is [0,1,2,3],
    we can map the index to the nums[n].

    0→1→3→2→4→3→2   

    Start from nums[n] as a new index, and so on,
    until the index exceeds the bounds. This produces a sequence similar to a linked list.

    0→1→3→2→4→null

    If there are a repeated numbers in the array, take the array [1,3,4,2,2] as an example,

    0→1→3→2→4→3→2→4→2
    Similarly, a linked list is like that:

    0→1→3→2→4→2→4→2→…0 
     */
    public static int findDuplicateFastSlowPointer(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
    } 
    /*
    If the array is sorted, 
    the value of each array element is its index value index+1, then we can do this:

    If nums[i]==i+1, it means that the order has been sorted, then skip, i++;
    If nums[i]==nums[nums[i]−1], it means that there is already a value at the correct index,
    then this value is a duplicated element;
    If none of the above is satisfied, exchange the values of nums[i] and nums[nums[i]−1].
    With extra O(logn) space, with modifying the input.
    Time Complexity: O(n)
    Space Complexity: O(1)
 */
// 1,3,5,3,7,8,44
public static int findDuplicateCycleSort(int[] nums) {
    int len = nums.length;
    for (int i = 0; i < len; ) {
        int n = nums[i];
        if (n == i + 1) {
            i++;
        } else if (n == nums[n - 1]) {
            return n;
        } else {
            nums[i] = nums[n - 1];
            nums[n - 1] = n;
        }
    }

    return 0;
}
    // Sorting the array first, then use a loop from 1 to n.
    // Time Complexity: O(nlogn)
    // Space Complexity: O(logn)
    public static int findDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return len;
    }

    // Since all values of the array are between 
    // [1…n] and the array size is n+1, while scanning the array from left to right, 
    // we set the nums[n] to its negative value.

    // With extra O(1) space, '''with modifying the input.
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static int findDuplicateMarkVisited(int[] nums) {
        int len = nums.length;
        for (int num : nums) {
            int idx = Math.abs(num);
            if (nums[idx] < 0) {
                return idx;
            }
            nums[idx] = -nums[idx];
        }

        return len;
    }
//  Using a HashSet\texttt{HashSet}HashSet to record the occurrence of each number.
//  With extra O(n) space, without modifying the input.
//  Time Complexity: O(n)
//  Space Complexity: O(n)
public static int findDuplicateHashset(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int len = nums.length;
    for (int i = 0; i < len; i++) {
        if (!set.add(nums[i])) {
            return nums[i];
        }
    }

    return len;
}

//  Count the frequency of the num in the array.
//  With extra O(n) space, without modifying the input.
//  Time Complexity: O(n)
//  Space Complexity: O(n)
    public static int findDuplicateArrayFrequency(int[] nums) {
        int len = nums.length;
        int[] cnt = new int[len + 1];
        for (int i = 0; i < len; i++) {
            cnt[nums[i]]++;
            if (cnt[nums[i]] > 1) {
                return nums[i];
            }
        }

        return len;
    }
    /*
    Since solve the problem without modifying the array nums and uses only constant extra space, 
    we can use Brute Force to solve it.

    It's easy to use 2 loops to do it, but the time complexity is n^2,
    so it wouldn't accepted as timeout.
    */
    public static int findDuplicate_2loops(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return len;
    }
}
