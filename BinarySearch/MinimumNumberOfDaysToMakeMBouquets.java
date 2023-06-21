// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

// You are given an integer array bloomDay, an integer m and an integer k.

// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

// The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

// Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

package BinarySearch;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        if(m>bloomDay.length/k) return -1;
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int i:bloomDay){
            if(i>end) end = i;
            if(i<start) start=i;
        }
        while(start<end){
            int mid = start + (end-start)/2;
            int flowers = 0;
            int adj = 0;
            for(int i:bloomDay){
                
                if(i<=mid) adj++;
                else adj=0;
                if(adj==k){
                    flowers++;
                    adj=0;
                }
            }
            
            if(flowers>=m) end = mid;
            else start = mid + 1;
        }
        return end;
    }
}
