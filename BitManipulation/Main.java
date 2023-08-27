package BitManipulation;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int num = 42;
        // System.out.println(findUnique(new int[] {1,2,3,4,2,1,3,4,9}));
        System.out.println(Arrays.toString(findTwoUniques(new int[] {3,4,6,3})));
        
        
                
    }

    private static boolean isPowerofTwo(int n) {
        return ((n & (n-1)) == 0);
    }

    private static int setIthBit(int num, int i) {
        return (num | (1<<i));
    }

    private static int getIthBit(int num,int i) {
        if((num & (1<<i))>0) return 1;
        return 0;
    }

    private static int resetIthBit(int num, int i) {
        return (num & ~(1<<i));
    }

    private static int convertToDecimal(String bString) {
        return Integer.parseInt(bString,2);
    }

    private static String convertToBinary(int num) {
        return Integer.toBinaryString(num);
    }
    private static int countSetBits(int num){
        int count = 0;
        while(num!=0){
            num = (num&(num-1));
            count++;
        }
        return count;
    }
    private static int findUnique(int[] num){
        int xor =0;
        for(int i:num){
            xor^=i;
        }
        return xor;
    }
    private static int[] findTwoUniques(int [] num){
        int xor =0;
        for(int i:num){
            xor^=i;
        }
        int orignalXor = xor;
        int cnt = 0;
        cnt = findFirstSetBit(xor);
        System.out.println(cnt);
        for(int i:num){
            if(getIthBit(i, cnt-1)!=0){
                xor^=i;
            }
        }
        orignalXor ^=xor;
        return new int[] {xor,orignalXor};
    }
    private static int findFirstSetBit(int num){
        int count = 0;
        if(num<=0) return count;
        int bit = 0;
        while(bit!=1){
            bit = num & 1;
            count++;
            num=num>>1;
        }
        return count;
    }
}
