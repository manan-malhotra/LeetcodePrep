// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

// Tags: BinarySearch

package BinarySearch;

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,1,3,7,9,10,8,6,4,2};
        System.out.println(peakIndexInMountainArray(arr));
    }

    private static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid+1]>arr[mid]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return end;
    }
}
