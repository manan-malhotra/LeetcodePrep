// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
/*
Given an integer array nums of length n where all the integers of nums are in the range [
1, n] and each integer appears once or twice, 
return an array of all the integers that appears twice.
You must write an algorithm that runs in O(n) time and uses only constant extra space.
 */
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[] num = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDuplicatesHashArray(num));
        System.out.println(findDuplicates(num));
        System.out.println(findDuplicatesHashMaps(num));
        System.out.println(findDuplicatesSort(num));
        System.out.println(findDuplicatesNegative(num));

    }
    // Cycle sort
    public static List<Integer> findDuplicates(int[] nums) {
        // TC: O(n) + O(n) ~ O(n)
        // SC: O(1)

        int i = 0;
        while (i < nums.length) {
            int correctIdx = nums[i] - 1;
            if (nums[i] != nums[correctIdx]) {
                swap(nums, i, correctIdx);
            }
            else i++;
        }

        List<Integer> ans = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    // Negative marking approach:
    public static List<Integer> findDuplicatesNegative(int[] nums) {
        // TC: O(n), SC: O(m)
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                ans.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }

        return ans;
    }
    public static List<Integer> findDuplicatesHashArray(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int ans[]=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
          ans[nums[i]]++; 
        }
        for(int i=0;i<=nums.length;i++)
        {
         if(ans[i]>1)
             list.add(i);
        }
        return list;

    }
    public static List<Integer> findDuplicatesHashMaps(int[] nums) {
        // TC: O(n + n) ~ O(n)
        // SC: O(n + m)
        // m be the number of duplicates
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                ans.add(key);
            }
        }

        return ans;
    }
    public static List<Integer> findDuplicatesSort(int[] nums) {
        // TC: O(n * logn) + O(n) ~ O(n * logn)
        // SC: O(m) -> where m is the number of duplicates
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                ans.add(nums[i]);
            }
        }

        return ans;
    }
    
}
