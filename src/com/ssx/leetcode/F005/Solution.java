package com.ssx.leetcode.F005;

public class Solution {
    public Solution(){
        String s= "abbbbba";
        System.out.println(longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        char[] str = s.toCharArray();
        int[] max = new int[2];
        for(int i=0;i<len;i++){
            for(int j=len-1;j>i;j--){
                int x = i;
                int y = j;
                boolean flag = true;
                if(str[x] == str[y]){
                    while(x<=y){
                        if(str[x] == str[y]){
                            x ++;
                            y --;
                        }else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag == true){

                        if(j+ 1 -i > max[1] - max[0]){
                            max[0] = i;
                            max[1] = j;
                        }
                        break;
                    }
                }
            }

        }
        return s.substring(max[0],max[1]+1);
    }
}
