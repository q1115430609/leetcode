package com.ssx.leetcode.answer.F454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Solution(){
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        fourSumCount(A,B,C,D);
    }
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        for(Integer a:A){
            for(Integer b:B){
                map.put(a+b,map.getOrDefault(a+b,0)+1);
            }
        }
        int res = 0;
        for(Integer c:C){
            for(Integer d:D){
                if(map.containsKey(-c-d)){
                    res += map.get(-c-d);
                }
            }
        }
        return res;
    }
}
