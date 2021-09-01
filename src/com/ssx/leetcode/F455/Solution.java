package com.ssx.leetcode.F455;

import java.util.Arrays;

public class Solution {
    public Solution(){
        int[] g = {1,2,3};
        int[] s = {1,1};
    }
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int x =0,y=0;
        while(x<g.length && y<s.length){
            if(s[y] >= g[x]){
                res ++;
                x ++;
                y++;
            }else{
                y++;
            }
        }
        return res;
    }
}
