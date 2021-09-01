package com.ssx.leetcode.F1365;

public class Solution {
    public Solution(){
        int[] a = {8,1,2,2,3};
        smallerNumbersThanCurrent(a);
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] A = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int curNum = 0;
            for(int j=0;j<nums.length;j++){
                if(j != i){
                    if(nums[j] < nums[i]){
                        curNum++;
                    }
                }
            }
            A[i] = curNum;

        }
        return A;
    }
}
