package com.ssx.leetcode.answer.F1047;

public class Solution {
    public Solution(){
        String S = "abbaca";
        removeDuplicates(S);
    }
    public String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for(int i=0;i<S.length();i++){
            int ch = S.charAt(i);
            if(top >-1 && stack.charAt(top)== ch){
                stack.deleteCharAt(top);
                top --;
            }else{
                stack.append(S.charAt(i));
                top++;
            }
        }
        return stack.toString();
    }
}
