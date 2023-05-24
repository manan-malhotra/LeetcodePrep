// https://leetcode.com/problems/contiguous-array/description/

// Given a binary array nums, return the maximum length of a contiguous subarray
//  with an equal number of 0 and 1.

// Tags: HashMap
package Arrays;

import java.util.HashMap;
import java.util.Map;

public class ContigousArray {

    public static void main(String[] args) {
        int[] arr = new int[] {1,0,0,0,1,0,1};
        System.out.println(findMaxLength(arr));
    }
    public static int findMaxLength(int[] arr){
        Map<Integer,Integer> hm = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i=0;i<arr.length;i++){
            int add = 1;
            if(arr[i]==0) add = -1;
            sum+=add;
            if(sum==0){
                maxLen= Math.max(maxLen, i+1);
            }
            if(hm.containsKey(sum)){
                int len = i-hm.get(sum);
                if(len>maxLen){
                    maxLen=len;
                }
            }else{
                hm.put(sum, i);
            }
        }
        return maxLen;
    }
    
}

