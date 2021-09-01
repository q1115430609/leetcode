package com.ssx.sortMethod;

public class SelectionSort {
    public SelectionSort(){
        int[] nums = {3,5,1,6,10,2,20,7};
        sort(nums);
    }
    public int[] sort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int min = nums[i];
            int index = i;
            for(int j=i+1;j<nums.length;j++){
                if(min > nums[j]){
                    min = nums[j];
                    index = j;
                }
            }
            if(min < nums[i]){
                int t = nums[i];
                nums[i] = nums[index];
                nums[index] = t;
            }
        }
        return nums;
    }
}
