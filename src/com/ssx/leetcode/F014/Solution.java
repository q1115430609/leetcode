package com.ssx.leetcode.F014;

public class Solution {
    public Solution(){
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int x= 0;
        int contain = 0;
        int len = 1000;
        for( int i = 0;i< strs.length;i ++){
            if(strs[i].length() < len){
                len = strs[i].length();
                contain = i;
            }
        }
        while(x < len){
            boolean flag = true;
            for(int i =0;i<strs.length;i++){
                if(!strs[i].substring(x,len).contains(strs[contain].substring(x,len))){
                    flag = false;
                }
            }
            if(flag) {
                return strs[contain].substring(x, len);
            }else{
                len --;
            }
        }

        return "";
    }
}
