package com.ssx.leetcode.F135;

public class Solution {
    public Solution(){
        int[] ratings = {1,0,2};
        candy(ratings);
    }
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] num = new int[len];
        num[0] = 1;
        for(int i=1;i<len;i++){
            if(ratings[i] > ratings[i-1]){
                num[i] = num[i-1] + 1;
            }else{
                num[i] = 1;
            }
        }
        for(int i=len-2;i>=0;i--){
            if(ratings[i] > ratings[i + 1 ] && num[i] <= num[i+1]){
                num[i] = num[i+1] + 1;
            }
        }
        int sum = 0;
        for(int i:num){
            sum += i;
        }
        return sum;
    }
}
