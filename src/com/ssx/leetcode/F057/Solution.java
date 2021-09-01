package com.ssx.leetcode.F057;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Solution(){
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] a =insert(intervals,newInterval);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.println(a[i][j]);
            }
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean flag = false;
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
            if(interval[0] > right){
                if(!flag){
                    flag = true;
                    list.add(new int[]{left,right});
                }
                list.add(interval);
            }else if(interval[1] < left){
                list.add(interval);
            }else{
                left  = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if(!flag){
            list.add(new int[]{left,right});
        }
        int[][] A = new int[list.size()][2];
        for(int i =0;i<list.size();i++){
            A[i] = list.get(i);
        }
        return A;
    }
}
