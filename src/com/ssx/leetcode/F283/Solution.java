package com.ssx.leetcode.F283;

public class Solution {
    public Solution(){
        int[] nums = {4,2,4,0,0,3,0,5,1,0};
        moveZeroes(nums);
    }
    public void moveZeroes(int[] nums) {
        int x =0,y=0;
        while(y < nums.length) {
            if (nums[y] != 0) {
                int t = nums[x];
                nums[x] = nums[y];
                nums[y] = t;
                x++;
            }
            y++;
        }
    }
}
