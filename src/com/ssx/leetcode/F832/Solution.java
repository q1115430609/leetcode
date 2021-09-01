package com.ssx.leetcode.F832;

public class Solution {
    public Solution(){
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        flipAndInvertImage(A);
    }
    public int[][] flipAndInvertImage(int[][] A) {
        int x = A.length;
        int y = A[0].length;
        int[][] B = new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=y-1;j>=0;j--){
                B[i][y-j-1] = (1-A[i][j]);
            }
        }
        return B;
    }
}
