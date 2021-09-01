package com.ssx.leetcode.F766;

public class Solution {
    public Solution(){
        int[][] matrix = {{36,59,71,15,26,82,87},{56,36,59,71,15,26,82},{15,0,36,59,71,15,26}};
        System.out.println(isToeplitzMatrix(matrix));
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j] != matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
