package com.ssx.leetcode.F1370;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public Solution(){
        String s = "aaaabbbbcccc";
        sortString(s);
    }
    public String sortString(String s) {
        String rs = "";
        int[] rl = new int[26];
        for(int i=0;i<s.length();i++){
            rl[s.charAt(i)-'a'] ++;
        }
        while(rs.length() < s.length()){
            for(int i=0;i<26;i++){
                if(rl[i] >0){
                    rs += (char)(i+'a');
                    rl[i] --;
                }
            }
            for(int i=25;i>=0;i--){
                if(rl[i] >0){
                    rs += (char)(i + 'a');
                    rl[i] --;
                }
            }
        }

        return rs;
    }
}
