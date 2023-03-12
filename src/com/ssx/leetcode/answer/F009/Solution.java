package com.ssx.leetcode.answer.F009;

public class Solution {
    public Solution(){
        boolean b = isPalindrome(121);
        System.out.println(b);
    }
    /* self */
//    public boolean isPalindrome(int x) {
//        if(x<0){
//            return false;
//        }
//        String str = Integer.toString(x);
//        for(int i=0;i<str.length()/2;i++){
//            if(str.charAt(i) != str.charAt(str.length()-1 - i)){
//                return false;
//            }
//        }
//        return true;
//    }
    /* authority */
    public boolean isPalindrome(int x) {
        if( x<0 || (x%10 ==0 && x != 0)){
            return false;
        }
        int revertNum = 0;
        while(x > revertNum){
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }

        return x == revertNum || x == revertNum / 10;
    }
}
