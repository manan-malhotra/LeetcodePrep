package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if(nums[0]>0) return ans;
        for(int i=0;i<nums.length-2;i++){
            if(i==0|| nums[i]!=nums[i-1]) {
                int a = i+1;
                int b = nums.length-1;
                
                while(a<b){
                    int sum = nums[i]+nums[a]+nums[b];
                    if(sum==0){
                        ans.add(Arrays.asList(nums[i], nums[a], nums[b]));
                        while(a<b && nums[a]==nums[a+1]) a++;
                        while(a<b && nums[b]==nums[b-1]) b--;
                        a++;
                        b--;
                    }else if(sum>0) b--;
                    else a++;
                }
            }
        }
        return ans;
    }

}
