package com.ssx.leetcode.answer.F977;

import java.util.Arrays;

public class Solution {
    public Solution(){
        int[] A = {-3,-1,0,5,9};
        sortedSquares(A);
    }
    public int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        for(int i=0;i<A.length;i++){
            B[i] = A[i] * A[i];
        }
        Arrays.sort(B);
        return B;
    }
}
