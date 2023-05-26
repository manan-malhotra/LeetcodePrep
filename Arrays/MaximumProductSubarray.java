// https://leetcode.com/problems/maximum-product-subarray/

// Given an integer array nums, find a subarray that has the largest product, and return the product.

// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// Tags: Dynamic Programming, Kadane
package Arrays;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{2,-5,-2,-4,3};
        System.out.println(maxProduct(nums));
        System.out.println(maxProductKadane(nums));
    }
    public static int maxProduct(int[] arr) {
        int maxProd = Integer.MIN_VALUE;
        int pre = 1, suff = 1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre*=arr[i];
            suff*=arr[n-i-1];
            maxProd = Math.max(maxProd, Math.max(pre, suff));
        }
        return maxProd;
    }
    // Very hard to understand, not intuitive
    public static int maxProductKadane(int[] arr) {
        int maxProd = arr[0];
        int iMin = arr[0], iMax = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = Math.max(arr[i]*iMin,Math.max(arr[i]*iMax, arr[i]));
            iMin = Math.min(arr[i]*iMax,Math.min(arr[i]*iMin, arr[i]));
            iMax = temp;
            maxProd = Math.max(iMax, maxProd);
        }
        return maxProd;
    }
    
}
