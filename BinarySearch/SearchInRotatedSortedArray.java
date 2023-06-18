package BinarySearch;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }

    public static int search(int[] nums, int target) {
        int end = nums.length-1;
        if(nums[0]<=nums[end]) {
            return binarySearch(nums, target, 0, end);
        }
        int peak = findPeak(nums);
        
        int ans = binarySearch(nums, target, 0, peak);
        if(ans == -1) {
            ans = binarySearch(nums, target, peak+1, end);
        }
        return ans;
    }

    private static int findPeak(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid-1]>nums[mid]){
                return mid-1;
            }else if(nums[mid]<nums[start]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target,int start, int end) {
        while(start<=end){
            int mid = start + (end-start)/2;
            int ans = arr[mid];
            if(ans==target){
                return mid;
            }else if(ans>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    
}
