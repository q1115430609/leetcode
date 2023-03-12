package com.ssx.leetcode.answer.F830;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Solution(){

    }
    public List<List<Integer>> largeGroupPositions(String s) {
        s = s+ "A";
        List<List<Integer>> li = new ArrayList<>();
        int x = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) != s.charAt(i)){
                if(i - x >= 3){
                    List<Integer> lis = new ArrayList<>();
                    lis.add(x);
                    lis.add(i-1);
                    li.add(lis);
                }
                x = i;
            }
        }
        return li;
    }
}
