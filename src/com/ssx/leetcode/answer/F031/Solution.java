package com.ssx.leetcode.answer.F031;

import java.util.Arrays;

public class Solution {
    public Solution(){
        int[] nums = {1,3,2};
        nextPermutation(nums);
//        reversea(nums,0);
    }
    public void nextPermutation(int[] nums) {
        boolean flag = false;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i] > nums[i-1]){
                int num = nums[i-1];
                int minNum = nums[i];
                int minIndex = i;
                for(int cc = i;cc<nums.length;cc++){
                    if(nums[cc] >num && nums[cc] < minNum){
                        minNum = nums[cc];
                        minIndex = cc;
                    }
                }
                swap(nums,i-1,minIndex);
                reverse(nums,i);
                flag = true;
                break;
            }
        }
        if(!flag){
            Arrays.sort(nums);
        }
    }
    public void swap(int[] nums,int i,int j){
        int f = nums[i];
        nums[i] = nums[j];
        nums[j] = f;
    }
    public void reverse(int[] nums,int i){
        for(int j=i;j<nums.length;j++){
            for(int z=nums.length-1;z>j;z--){
                if(nums[z]<nums[z-1]){
                    swap(nums,z,z-1);
                }
            }
        }
    }

//    public void reversea(int[] nums, int start) {
//        int left = start, right = nums.length - 1;
//        while (left < right) {
//            swap(nums, left, right);
//            left++;
//            right--;
//        }
//        int a = 0;
//    }
}
