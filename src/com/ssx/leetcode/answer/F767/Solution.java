package com.ssx.leetcode.answer.F767;

public class Solution {
    public Solution(){
        String  S = "aaba";
        String zz =reorganizeString(S);
        System.out.println(zz);
    }
    public String reorganizeString(String S) {
        int[] temp = new int[26];
        for(int i=0;i<S.length();i++){
            temp[S.charAt(i) - 'a'] ++;
        }
        boolean flag = true;
        String res = "";
        while(flag){
            int num = 0;
            int index = 0;
            for(int i=0;i<26;i++){
                if(temp[i] > 0){
                    temp[i] --;
                    num += 1;
                    res += (char)('a' + i);
                    index = i;
                }
            }
            if(num == 0){
                flag = false;
            }
            if(num == 1){
                if(temp[index] >0){
                    return "";
                }else{
                    flag = false;
                }
            }
        }
        return res;
    }
}
