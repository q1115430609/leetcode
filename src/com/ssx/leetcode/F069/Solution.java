package com.ssx.leetcode.F069;

public class Solution {
    public Solution(){
        mySqrt(10);
    }
    /*public int mySqrt(int x) {
        int maxNum = Integer.MAX_VALUE;
        for(int i=1;i<maxNum;i++){
            if(x / i < i){
                return i -1;
            }
        }
        return 0;
    }*/
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int outPut = -1;
        while(l <= r){
            int mid = l +(r-1) / 2;
            if((long) mid * mid <= x){
                outPut = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return outPut;
    }
}
