package com.ssx.leetcode.answer.F389;

public class Solution {
    public Solution(){
        String s = "aaa";
        String t = "aaab";
        int[] a = new int[2];
        char c =findTheDifference(s,t);
        System.out.println(c);
    }
    public char findTheDifference(String s, String t) {
        int length = s.length();
        char c = t.charAt(length);
        for(int i=0;i<length;i++){
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
