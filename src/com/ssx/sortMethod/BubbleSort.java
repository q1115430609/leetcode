package com.ssx.sortMethod;

public class BubbleSort {
    // 冒泡排序
    public BubbleSort(){
        int[] nums = {3,5,1,6,10,2,20,7};
        sort(nums);
    }
    public int[] sort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] > nums[j]){
                    int t = nums[i];
                    nums[i]= nums[j];
                    nums[j] = t;
                }
            }

        }
        return nums;
    }

}
