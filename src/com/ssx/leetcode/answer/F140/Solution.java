package com.ssx.leetcode.answer.F140;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public Solution(){
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("dog");
        wordBreak(s,wordDict);
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        System.out.println(new HashSet<String>(wordDict));
        return null;
    }
}
