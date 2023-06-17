package BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,3,4,6,9,11};
        int target = 2;
        System.out.println(binarySearch(arr,target));
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
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
