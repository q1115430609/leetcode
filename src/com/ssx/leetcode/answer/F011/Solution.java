package com.ssx.leetcode.answer.F011;

public class Solution {
    public Solution(){
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0,right = height.length - 1;
        while(left < right){
            int minHei = Math.min(height[left],height[right]);
            max = Math.max(max,(right - left) * minHei);

            while(height[left] <= minHei && left < right){
                left ++;
            }
            while(height[right] <= minHei && left < right){
                right--;
            }
        }
        return max;
    }
}
