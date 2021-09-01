package com.ssx.leetcode.F011;

public class Solution {
    public Solution(){
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }
    public int maxArea(int[] height) {
        int len = height.length;
        int x = 0;
        int y = len - 1;
        int area = 0;
        while(x<y){
            int hei = Math.min(height[x],height[y]);
            area = Math.max(area,hei * (y-x));
            if(height[y] > height[x]){
                x ++;
            }else{
                y --;
            }
        }
        return area;
    }
}
