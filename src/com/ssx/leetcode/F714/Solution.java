package com.ssx.leetcode.F714;

public class Solution {
    public Solution(){
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int a = maxProfit(prices,fee);
        System.out.println(a);
    }
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<len;i++){
            // 0 今天卖掉
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i] -fee);
            // 1 今天没卖掉
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }
}
