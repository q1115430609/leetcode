package com.ssx.leetcode.F925;

public class Solution {
    public Solution(){
        String name = "alex";
        String typed= "alexxr";
        isLongPressedName(name, typed);
    }
    public boolean isLongPressedName(String name, String typed) {
        if(name.charAt(name.length() -1) != typed.charAt(typed.length() - 1) || name.charAt(0) != typed.charAt(0)){
            return false;
        }
        int x = 0;
        int y = 0;
        while(x<name.length()){
            if(y>typed.length()-1){
                return false;
            }
            if(name.charAt(x) == typed.charAt(y)){
                y++;
                x++;
            }else if(typed.charAt(y)==name.charAt(x-1)){
                y++;
            }else{
                return false;
            }
        }
        return true;
    }
}
