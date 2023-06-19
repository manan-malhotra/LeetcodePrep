// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

// Can contain duplicates

package BinarySearch;

public class SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 2;
        System.out.println(search(nums,target));
    }

    private static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]==nums[start] && nums[mid]==nums[end]){
                start++;
                end--;
            }
            else if(nums[start]<=nums[mid]){
                // LHS is sorted
                if(target>=nums[start] && target<nums[mid]){
                    end = mid-1;
                }else{
                    start = mid + 1;
                }

            }else{
                // RHS is sorted
                if(target>nums[mid] && target<=nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }

            }
        }
        return false;
    }
    
}
