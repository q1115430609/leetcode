package com.ssx.leetcode.F067;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Solution(){
        String a = "10101";
        String b = "111";
        String out = addBinary(a,b);
        System.out.println(out);
    }
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        for(int i = 0;i < Math.max(lena,lenb);i++){
            int x = (lena- 1 - i) >= 0 ? Integer.valueOf(String.valueOf(a.charAt(lena- 1 - i))) : 0;
            int y = (lenb- 1 - i) >= 0 ? Integer.valueOf(String.valueOf(b.charAt(lenb- 1 - i))) : 0;
            if(x + y + flag > 1){
                sb.append(String.valueOf(x + y + flag - 2));
                flag = 1;
            }else{
                sb.append(String.valueOf(x + y + flag));
                flag = 0;
            }
        }
        if(flag == 1){
            sb.append("1");
        }
        return String.valueOf(sb.reverse());
    }
}
