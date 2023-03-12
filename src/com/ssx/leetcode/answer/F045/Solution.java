package com.ssx.leetcode.answer.F045;

import java.util.ArrayList;
import java.util.List;

//未完成
public class Solution {
    public Solution(){
        int[] nums = {2,3,1,1,4};
        int a = jump(nums);
        System.out.println(a);
    }
    public int jump(int[] nums) {
        int jump = 0;
        int end = 0,maxPosition = 0,length = nums.length-1;
        for(int i=0;i< length;i++){
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if(i == end){
                end = maxPosition;
                jump++;
            }
        }
        return jump;
    }
}
