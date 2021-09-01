package com.ssx.competition.mergeAlternately;

import java.util.Date;

public class Solution {
    public Solution(){
        String word1 = "abcasdasdasdasdasdasdasdasdospdsopdofgfgegertertertertertertertertertetertertetrertertertspdospdospodpsod";
        String word2 = "efgasdasdasffqfqweqwieuqwoejqwkleqlzxnclzqoweiqwoeiqwnklcxnzlkqweqweklqwejlqkwejqwlekjqwelkqwe";
        mergeAlternately(word1,word2);
    }
    public String mergeAlternately(String word1, String word2) {
        Long date = new Date().getTime();
        int x= 0;
        int y = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder s = new StringBuilder();
        while(x < len1 || y < len2){
            if(x < len1){
                s.append(word1.charAt(x));
                x++;
            }
            if(y < len2){
                s.append(word2.charAt(y));
                y++;
            }
        }
        Long date1 = new Date().getTime();
        System.out.println(date1 - date);
        return s.toString();
    }
}
