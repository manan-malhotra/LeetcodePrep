// https://leetcode.com/problems/missing-number/description

// Given an array nums containing n distinct numbers in the range [0, n], 
// return the only number in the range that is missing from the array.

// Tags: Cycle Sort, XOR, Math, Binary Search

package Arrays;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(arr));
        System.out.println(missingNumberXOR(arr));
        System.out.println(missingNumberSum(arr));
        System.out.println(missingNumberBinarySearch(arr));
    }
    public static int missingNumber(int[] arr) { // Cycle Sort O(n)
        int i = 0;
       while(i<arr.length){ // cycle sort
           if(i==arr[i] || arr[i] == arr.length){
               i++;
           }else{
               swap(arr,i,arr[i]);
           }
       }
       for( i=0; i<arr.length;i++){ // if index is missing the val
           if(i!=arr[i]) return i; // return index
       }
       return arr.length; // else return max index
   }
    public static void swap(int[] arr, int i, int j) {
       int temp = arr[i];
       arr[i]=arr[j];
       arr[j]=temp;
   }
   public static int missingNumberXOR(int[] nums) { // XOR O(n)
    int res = nums.length;  // res = len
    for(int i=0; i<nums.length; i++){
        res ^= i; // xor all index values
        res ^= nums[i]; // xor all values
    }
    return res;
}
// If anyone needs explanation for XOR solution,
//  a number XOR itself will become 0, 
// any number XOR with 0 will stay unchanged. 
// So if every number from 1...n XOR with itself except the missing number, 
// the result will be the missing number.

// Example:
// 1..4 missing 3
//  1^2  ^4

// ^1^2^3^4
//  0^0^3^0 => 3
public static int missingNumberSum(int[] nums) { // Sum O(n)
    int len = nums.length;
    int sum = (0+len)*(len+1)/2;
    for(int i=0; i<len; i++)
        sum-=nums[i];
    return sum;
}
public static int missingNumberBinarySearch(int[] nums) { //binary search (nlgn)
    Arrays.sort(nums);
    int left = 0, right = nums.length, mid= (left + right)/2;
    while(left<right){
        mid = (left + right)/2;
        if(nums[mid]>mid) right = mid;
        else left = mid+1;
    }
    return left;
}
}
