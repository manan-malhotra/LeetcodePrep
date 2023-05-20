// https://leetcode.com/problems/product-of-array-except-self/description/
//Given an integer array nums, return an array answer such that answer[i] is equal 
//to the product of all the elements of nums except nums[i].

//You must write an algorithm that runs in O(n) time and without using the division operation.

package Arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelfArrays(nums)));

    }
    public static int[] productExceptSelf(int[] nums) {
        int[] numsProduct = new int[nums.length]; // Creating an array to store products.
         int preProduct = 1, postProduct = 1; // Initializing a prefix, and postfix product.
 
         // Find product of each array i, but exclude i.
             // By calculating the left and right products seperately we are able to calculate in O(N) time.
         for(int i = 0; i < nums.length; i++){ // Left Index
             numsProduct[i] = preProduct;
             preProduct *= nums[i];
         }
         
         for(int i = nums.length - 1; i >= 0; i--){ // Right Index
             numsProduct[i] *= postProduct;
             postProduct *= nums[i];
         }
 
         return numsProduct;
     }
     public static int[] productExceptSelfArrays(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int suff[] = new int[n];
        pre[0] = 1;
        suff[n - 1] = 1;
        
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }
        
        int ans[] = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }
}
