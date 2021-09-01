package com.ssx.leetcode.F027;

import java.util.List;
public class Solution {
    public Solution(){
        int[] nums = {1,2,3,4,5};
        int val = 2;
        int a =removeElement(nums,val);
        System.out.println(a);
    }
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int j = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
