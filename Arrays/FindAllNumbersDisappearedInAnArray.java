// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array

// Given an array nums of n integers where nums[i] is in the range [1, n], 
// return an array of all the integers in the range [1, n] that do not appear in nums.

// Tags: Cycle sort, HashMap, HashSet

package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbersBrute(nums));
        System.out.println(findDisappearedNumbers(nums));
        System.out.println(findDisappearedNumbersHashMap(nums));
        System.out.println(findDisappearedNumbersHashSet(nums));
        
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) { // Cycle sort
        int i = 0;
        List<Integer> arr = new ArrayList<>();
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[i]==nums[correct]){
                i++;
            }else{
                swap(nums,i,correct);
            }
        }
        for(int j=0;j<nums.length;j++){
            if(j!=nums[j]-1){
                arr.add(j+1);
            }
        }
        return arr;
    }



   
     public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static List<Integer> findDisappearedNumbersHashMap(int[] nums) {
        //since we have to find the missing numbers from
        //store the  valuses of all array elments in map
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],1);
        }
        List<Integer> ans=new ArrayList<>();
        //now check the given array 
        //nums from 1 to nums.length(incusive) if
        //it the i is not in map means it is missing
        //add to ans list
        for(int i=1;i<=nums.length;i++)
        {
            if(map.containsKey(i)==false)
            {
                ans.add(i);
            }
        }
        return ans;
		//please upvote if you found helpful it will give some motivation
        
    }
        public static List<Integer> findDisappearedNumbersHashSet(int[] a) {
            Set<Integer> set = new HashSet<>();
            ArrayList<Integer> result = new ArrayList<>();
    
            for (int i : a) set.add(i); // removing duplicate elements
    
           for(int i = 1; i <= a.length; i++){
               if(!set.contains(i)) result.add(i);
           }
            return result;
        }
        public static List<Integer> findDisappearedNumbersBrute(int[] nums) {
            int[] res = new int[nums.length + 1];
        
            for (int num : nums) {
                res[num] = num;
            }
        
            List<Integer> result = new ArrayList<>(res.length);
            for (int i = 1; i < res.length; i++) {
                if (res[i] == 0) {
                    result.add(i);
                }
            }
        
            return result;
}
}

