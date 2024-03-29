package com.ssx.leetcode.answer.F860;

public class Solution {
    public Solution(){
        int[] bills = {5,5,10,10,20};
        lemonadeChange(bills);
    }
    public boolean lemonadeChange(int[] bills) {
        int five = 0,ten = 0;
        for(int i =0;i<bills.length;i++){
            if(bills[i] == 5){
                five ++;
            }else if(bills[i] == 10){
                five --;
                ten ++;
            }else{
                if(ten > 0){
                    ten --;
                    five --;
                }else{
                    five -= 3;
                }
            }
            if(five <0 || ten < 0){
                return false;
            }

        }
        return true;
    }
}
