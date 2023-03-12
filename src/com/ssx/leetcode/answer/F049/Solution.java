package com.ssx.leetcode.answer.F049;

import java.util.*;

public class Solution {
    public Solution(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(map.containsKey(s)){
                map.get(s).add(strs[i]);
            }else{
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                map.put(s,l);
            }
        }
        List<List<String>> list = new ArrayList<>(map.values());
        return list;
    }
}
