package com.ssx.leetcode.answer.F035;

public class Solution {
    public Solution(){
        int[] nums = {1,2,4,5};
        int target = 3;
        int a =searchInsert(nums,target);
        System.out.println(a);
    }
    public int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
