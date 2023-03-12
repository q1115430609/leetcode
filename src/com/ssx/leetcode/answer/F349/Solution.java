package com.ssx.leetcode.answer.F349;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public Solution(){
        int[] nums1 = {1,2,2,3};
        int[] nums2 = {4,2,6,9};
        int[] n = intersection(nums1,nums2);
        for(int i:n){
            System.out.println(i);
        }
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int a:nums1){
            for(int b:nums2){
                if(a == b){
                    set.add(a);
                    break;
                }
            }
        }
        Object[] obj = set.toArray();
        int[] re = new int[obj.length];
        for(int i=0;i<obj.length;i++){
            re[i] = (int) obj[i];
        }
        return re;
    }
}
