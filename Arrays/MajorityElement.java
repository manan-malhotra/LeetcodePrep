// https://leetcode.com/problems/majority-element/description/
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. 
// You may assume that the majority element always exists in the array.

// Tags: Sorting, HashMap, TODO Moore, TODO Bit manipulation


package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[] {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElementBrute(nums));
        System.out.println(majorityElementSort(nums));
        System.out.println(majorityElementMoore(nums));
        System.out.println(majorityElementBitManipulation(nums));
        
    }
    public static int majorityElementBrute(int[] nums) { //Brute Force Approach n^2 Worst
        int maxTotal = -1;
        int maxTotalAt = -1;
        for(int i=0;i<nums.length;i++){
            int maxSoFar = 0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]) maxSoFar++;
            }
            if(maxSoFar>maxTotal){
                maxTotal = maxSoFar;
                maxTotalAt = i;
            }
        }
        return nums[maxTotalAt];
    }
    // Sorting
public static int majorityElementSort(int[] nums) { // nlogn Approach. 
    Arrays.sort(nums);
    return nums[nums.length/2];
}

// Hashtable 
public static int majorityElement(int[] nums) {
    Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
    int ret=0;
    for (int num: nums) {
        if (!myMap.containsKey(num)) // Check whether value already exist in map
            myMap.put(num, 1);
        else
            myMap.put(num, myMap.get(num)+1);
        if (myMap.get(num)>nums.length/2) { // Break as soon as any key gets to more than n/2
            ret = num;
            break;
        }
    }
    return ret;
}

// TODO Moore voting algorithm
public static int majorityElementMoore(int[] nums) {
    int count=0, ret = 0;
    for (int num: nums) {
        if (count==0)
            ret = num;
        if (num!=ret)
            count--;
        else
            count++;
    }
    return ret;
}

// TODO Bit manipulation 
public static int majorityElementBitManipulation(int[] nums) {
    int[] bit = new int[32];
    for (int num: nums)
        for (int i=0; i<32; i++) 
            if ((num>>(31-i) & 1) == 1)
                bit[i]++;
    int ret=0;
    for (int i=0; i<32; i++) {
        bit[i]=bit[i]>nums.length/2?1:0;
        ret += bit[i]*(1<<(31-i));
    }
    return ret;
}
}
