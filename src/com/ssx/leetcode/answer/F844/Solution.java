package com.ssx.leetcode.answer.F844;

public class Solution {
    public Solution(){
        String S = "";
        String T = "";
        backspaceCompare(S,T);
    }
    public boolean backspaceCompare(String S, String T) {
        return (newString(S)).equals(newString(T));
    }
    public String newString(String S){
        StringBuffer s1 = new StringBuffer();
        for(int i =0;i<S.length();i++){
            if(S.charAt(i) != '#'){
                s1.append(S.charAt(i));
            }else{
                if(s1.length() > 0){
                    s1.deleteCharAt(s1.length() - 1);
                }
            }
        }
        return s1.toString();
    }
}
