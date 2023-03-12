package com.ssx.leetcode.answer.F649;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public Solution(){
        String a = "RD";
        predictPartyVictory(a);
    }
    public String predictPartyVictory(String senate) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i) == 'R'){
                que1.offer(i);
            }else{
                que2.offer(i);
            }
        }

        while(!que1.isEmpty() && !que2.isEmpty()){
            int a1 = que1.poll();
            int a2 = que2.poll();
            if(a1 < a2){
                que1.offer(a1 + senate.length());
            }else{
                que2.offer(a2 + senate.length());
            }
        }
        return que1.isEmpty()? "Radiant":"Dire";
    }
}
