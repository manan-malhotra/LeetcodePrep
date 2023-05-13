// https://www.codingninjas.com/codestudio/problems/longest-subarray-with-sum-k_6682399
// Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
// Example:
// Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
// Result: 3
// Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.
package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubarrayHashMap(a, k);
        System.out.println("The length of the longest subarray is: " + len);
        len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);


    }
    // Works only for positive int
    public static int getLongestSubarray(int []a, long k) {
        // O(2*N), where N = size of the given array.
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }
    // Works regarless for positive & negative int
    public static int getLongestSubarrayHashMap(int []a, long k) {
        // O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
        int n = a.length; // size of the array.

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}
