// https://leetcode.com/problems/koko-eating-bananas/description/

// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

// Return the minimum integer k such that she can eat all the bananas within h hours.


package BinarySearch;

public class KokoEatingBananas {

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int i: piles){
            if(i>max){
                max=i;
            }
        }
        while(min<max){
            int mid = min + (max-min)/2;
            int hoursReq = 0;
            for(int i:piles){
                hoursReq += (i/mid);
                if(i%mid!=0) hoursReq++;
            }
            //System.out.println(mid+" "+hoursReq);
            if(hoursReq <= h) max=mid;
            else min = mid+1;
        }
        return min;
    }
    
}
