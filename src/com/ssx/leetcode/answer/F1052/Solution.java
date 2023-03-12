package com.ssx.leetcode.answer.F1052;

public class Solution {
    public Solution(){
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int X = 3;
        int a = maxSatisfied(customers,grumpy,X);
        System.out.println(a);
    }
    // 超时
    public int maxSatisfied1(int[] customers, int[] grumpy, int X) {
        int y = 0;
        X = X -1;
        int maxSatisfiedNum = 0;
        while(y + X < customers.length){
            int satisfiedNum = 0;
            for(int i = 0;i<customers.length;i++){
                if(!(i >= y && i <= y+X)){
                    if(grumpy[i] == 0){
                        satisfiedNum += customers[i];
                    }
                }else{
                    satisfiedNum += customers[i];
                }
            }
            maxSatisfiedNum = Math.max(satisfiedNum,maxSatisfiedNum);
            y++;
        }
        return maxSatisfiedNum;
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int ret = 0, extra = 0, tmp = 0;
        int n = customers.length;
        int l = 0, r = 0;
        while(r < n) {
            ret += (1 - grumpy[r]) * customers[r];//确定满意的顾客
            //滑动窗口
            tmp += grumpy[r] * customers[r];
            r++;
            extra = Math.max(extra, tmp);
            if(r - l == X) {tmp -= grumpy[l] * customers[l++];}
        }
        return ret + extra;
    }
}
