// https://leetcode.com/problems/container-with-most-water/description/

// You are given an integer array height of length n. 
// There are n vertical lines drawn such that the two endpoints 
// of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, 
// such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
// In this case, the max area of water the container can contain is 49.

// Tags: Two Pointer

package Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left<right){
            int start = height[left];
            int end = height[right];
            int min = Math.min(start,end);
            int dist = right-left;
            int currArea = min * dist;
            maxArea = Math.max(currArea,maxArea);
            if(start>end){
                right--;
            }else{
                left++;
            }
        }
        return maxArea;
    }
    
}
