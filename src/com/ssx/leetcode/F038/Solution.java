package com.ssx.leetcode.F038;

/***
 * string 类型直接拼接用时 21ms ，StringBuilder 用时 3ms！！！！！！
 * 拼字符串 StringBuilder ！！！！！！！
 */
public class Solution {
    public Solution(){
        int a = 6;
        System.out.println(countAndSay(a));
    }
    public String countAndSay(int n) {
        String str = "1";
        int x= 1;
        while(x < n){
            StringBuilder strIn = new StringBuilder();
            char c = str.charAt(0);
            int z = 1;
            for(int i = 1;i<str.length();i++){
                if(c == str.charAt(i)){
                    z ++;
                }else{
                    strIn.append(z);
                    strIn.append(c);
                    c = str.charAt(i);
                    z = 1;
                }
            }
            strIn.append(z);
            strIn.append(c);
            str = strIn.toString();
            x ++;
        }
        return str;
    }
}
