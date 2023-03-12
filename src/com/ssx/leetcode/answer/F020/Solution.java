package com.ssx.leetcode.answer.F020;

import java.util.Stack;

public class Solution {
    public Solution(){
        String a = "([)]";
        System.out.println(isValid(a));
    }
    public boolean isValid(String strs) {
        Stack<Character> stack = new Stack<Character>();
        for(char c:strs.toCharArray()){
            if(c=='('){
                stack.push(')');
            }
            else if(c=='['){
                stack.push(']');
            }
            else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty() || c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
