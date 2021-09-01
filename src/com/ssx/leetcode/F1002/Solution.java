package com.ssx.leetcode.F1002;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public Solution(){
        String[] A = {"bella","label","roller"};
        commonChars(A);
    }
    public List<String> commonChars(String[] A) {
        List<String> ls = new ArrayList<>();
        int[] minArr = new int[26];
        Arrays.fill(minArr,Integer.MAX_VALUE);
        for(int i=0;i<A.length;i++){
            int[] curArr = new int[26];
            for(int j=0;j<A[i].length();j++){
                char ch = A[i].charAt(j);
                curArr[ch - 'a'] ++;
            }
            for(int z = 0;z<curArr.length;z++){
                minArr[z] = Math.min(minArr[z],curArr[z]);
            }
        }

        for(int i=0;i<minArr.length;i++){
            for(int j =0;j<minArr[i];j++){
                char c = (char) ('a' + i);
                ls.add(String.valueOf(c));
            }
        }

        return ls;
    }
}
