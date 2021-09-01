package com.ssx.leetcode.F867;

public class Solution {
    public Solution(){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        transpose(matrix);
    }
    public int[][] transpose(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int[][] ret = new int[y][x];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                ret[j][i] = matrix[i][j];
            }
        }
        return ret;
    }
}
