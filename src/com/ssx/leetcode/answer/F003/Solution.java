package com.ssx.leetcode.answer.F003;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public Solution(){
        String s = "pwwkew";
        int a = lengthOfLongestSubstring(s);
        System.out.println(a);
    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int r = -1,y = 0;
        for(int i=0;i<s.length();i++){
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            while(r + 1 < n && !set.contains(s.charAt(r + 1))){
                set.add(s.charAt(r+1));
                r++;
            }
            y = Math.max(y,set.size());
        }
        return y;
    }

}
