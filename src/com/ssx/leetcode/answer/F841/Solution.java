package com.ssx.leetcode.answer.F841;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int num;
    boolean[] ln;
    public Solution(){
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l1.add(3);
        l1.add(0);
        l1.add(1);
        List<Integer> l3 = new ArrayList<>();
        l1.add(2);
        List<Integer> l4 = new ArrayList<>();
        l1.add(0);
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        canVisitAllRooms(list);
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        ln = new boolean[len];
        dfs(rooms,0);
        return num == len;
    }
    public void dfs(List<List<Integer>> rooms,int index){
        ln[index] = true;
        num ++;
        for(int i: rooms.get(index)){
            if(!ln[i]){
                dfs(rooms,i);
            }
        }
    }
}
