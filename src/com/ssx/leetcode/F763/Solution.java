package com.ssx.leetcode.F763;

import java.util.ArrayList;
import  java.util.List;

public class Solution {
    public Solution(){
        String S = "ababcbacadefegdehijhklij";
        partitionLabels(S);
    }
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        List<String> str = new ArrayList<>();
        for(int i =0;i<S.length();i++){
            if(i==0){
                str.add(String.valueOf(S.charAt(0)));
            }else{
                boolean flag = false;
                for(int j =0;j<str.size();j++){
                    String a = String.valueOf(S.charAt(i));
                    if(str.get(j).contains(a)){
                        String midStr = "";
                        int lenth = str.size();
                        for(int z = j;z<lenth;z++){
                            midStr += str.get(z);
                        }
                        for(int c = 0;c<lenth - j;c++){
                            str.remove(j);
                        }
                        str.add(midStr + String.valueOf(S.charAt(i)));
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    str.add(String.valueOf(S.charAt(i)));
                }
            }
        }
        for(int i=0;i<str.size();i++){
            list.add(str.get(i).length());
        }

        return list;
    }
}
