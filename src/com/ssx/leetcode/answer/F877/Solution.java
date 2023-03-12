package com.ssx.leetcode.answer.F877;

public class Solution {
    public Solution(){
        int[] piles = {5,3,4,5};
        stoneGame(piles);
    }
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = piles[i];
        }
        for(int i = len -2;i>=0;i--){
            for(int j= i+1;j<len;j++){
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][len-1] > 0;
    }
}
