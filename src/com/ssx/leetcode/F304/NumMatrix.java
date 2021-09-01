package com.ssx.leetcode.F304;

public class NumMatrix {
    int[][] sums;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = 1;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=col1;i<col2;i++){
            for(int j=row1;j<row2;j++){
                sum += sums[i][j];
            }
        }
        return sum;
    }
}
