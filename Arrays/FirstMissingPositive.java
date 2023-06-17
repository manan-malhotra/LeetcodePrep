// https://leetcode.com/problems/first-missing-positive/description/

// Given an unsorted integer array nums, return the smallest missing positive integer.

// You must implement an algorithm that runs in O(n) time and uses constant extra space.

// Input: nums = [3,4,-1,1]
// Output: 2
// Explanation: 1 is in the array but 2 is missing.

package Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {3,0,-1,1,2};
        System.out.println(firstMissingPositive(nums));
    }

    private static int firstMissingPositive(int[] arr) {
        for (int i = 0; i < arr.length;) {
            int correct = arr[i]-1;
            if(arr[i]>0 && arr[i]<arr.length && arr[i]!=arr[correct]){
                swap(arr,i,correct);
            }else{
                i++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=i+1){
                return i+1;
            }
        }
        return arr.length ;
        
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
    }
    
}
