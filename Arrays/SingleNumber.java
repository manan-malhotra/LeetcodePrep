package Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int xor = 0;
        for(int i:nums){
            xor^=i;
        }
        return xor;
    }
}
