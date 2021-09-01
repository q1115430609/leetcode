package com.ssx.leetcode.F387;

public class Solution {
    public Solution(){
        String s = "";
        firstUniqChar(s);
    }
    public int firstUniqChar(String s) {
        int[] Word = new int[26];
        for(int i =0;i<s.length();i++){
            Word[s.charAt(i)-'a'] ++;
        }
        for(int j=0;j<s.length();j++){
            if(Word[s.charAt(j) - 'a'] == 1){
                return j;
            }
        }
        return -1;
    }
}
