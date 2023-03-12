package com.ssx.leetcode.answer.F134;

public class Solution {
    public Solution(){
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int a =canCompleteCircuit(gas,cost);
        System.out.println(a);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int init = 0;
        int len = gas.length;
        while(init < len){
            int x = init;
            int sumGas = 0;
            boolean flag = true;
            while(x<len + init){
                int j = x % len;
                sumGas += gas[j];
                if(sumGas >= cost[j]){
                    sumGas -= cost[j];
                    x++;
                } else{
                    flag = false;
                    break;
                }

            }
            if(flag){
                return init;
            }else{
                init ++;
            }
        }
        return -1;
    }
}
