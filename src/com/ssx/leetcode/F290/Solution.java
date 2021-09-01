package com.ssx.leetcode.F290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Solution(){
        String pattern = "aabb";
        String s = "a a b b";
        wordPattern(pattern,s);
    }
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map  = new HashMap<>();
        String[] slis = s.split(" ");
        if(pattern.length() != slis.length){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!slis[i].equals(map.get(pattern.charAt(i)))){
                    return false;
                }
            }
            else{
                for(Map.Entry<Character,String> entry:map.entrySet()){
                    if(entry.getValue().equals(slis[i])){
                        return false;
                    }
                }
                map.put(pattern.charAt(i),slis[i]);
            }
        }
        return true;
    }
}
