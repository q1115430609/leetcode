package com.ssx.leetcode.F051;

public class Solution {
    public Solution(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int a = maxSubArray(nums);
        System.out.println(a);
    }
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int num:nums){
            if(sum >= 0){
                sum += num;
            }else{
                sum = num;
            }
            max = Math.max(max,sum);
        }
        return max;
    }

}
