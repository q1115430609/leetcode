package com.ssx.leetcode.F941;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public Solution(){
        int[] A = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(validMountainArray(A));
    }
    public boolean validMountainArray(int[] A) {
        int x = 0,y=A.length;
        while(x + 1 < y && A[x] < A[x+1]){
            x ++;
        }
        if(x==0|| x== y -1){
            return false;
        }
        while(x+ 1<y && A[x] > A[x+1]){
            x ++;
        }
        return x==y -1;
    }
}
