package com.ssx.leetcode.answer.F922;

public class Solution {
    public Solution(){

    }
    public int[] sortArrayByParityII(int[] A) {
        int[] B = new int[A.length];
        int x = 0;
        int y = 1;
        for(int i=0;i<A.length;i++){
            if(A[i] % 2 ==0){
                B[x] = A[i];
                x += 2;
            }else{
                B[y] = A[i];
                y += 2;
            }
        }
        return B;
    }
}
