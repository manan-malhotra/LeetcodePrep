// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and 
// choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. 
// If you cannot achieve any profit, return 0.

// Tags: Array, DynamicProgramming, Kadane:TODO

package Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,0,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitBrute(prices));
        
    }
    public static int maxProfit(int[] prices) {
        int maxProfit = 0 ;
        int profitToday = 0;
        int leastSoFar = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            leastSoFar = Math.min(leastSoFar,prices[i]); // What is the least price of stock so far
            profitToday = prices[i]-leastSoFar; // What would be the best Profit if we bought at leastSoFar and sold today @ i
            if(profitToday>maxProfit) maxProfit = profitToday; 
        }
        return maxProfit;
    }

    public static int maxProfitBrute(int[] prices) { // Basic n^2 Approach of two loops
        int maxProfit = 0 ;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                int curr = prices[j]-prices[i];
                if(curr>maxProfit){
                    maxProfit = curr;
                }
            }
        }
        return maxProfit;
    }

}
