package com.ssx.leetcode.F066;

public class Solution {
    public Solution(){
        int[] nums = {8,9,9,9};
        int[] a = plusOne(nums);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public int[] plusOne(int[] digits) {
        int[] newdigits = reverse(digits);
        int flag= 0;
        for(int i=0;i<newdigits.length;i++){
            int num = 0;
            if(i==0){
                num = newdigits[i] + 1 + flag;
            }else{
                num = newdigits[i] + flag;
            }
            if(num > 9){
                newdigits[i] = 0;
                flag = 1;
            }else{
                newdigits[i] = num;
                flag = 0;
            }
        }
        int nnDigits[] = new int[newdigits.length + 1];
        if(flag == 1){
            for(int i = 0;i<newdigits.length;i++){
                nnDigits[i] = newdigits[i];
            }
            nnDigits[newdigits.length] = 1;
        }else{
            nnDigits = newdigits;
        }
        return reverse(nnDigits);
    }

    public int[] reverse(int[] source){
        int len = source.length;
        for(int i=0;i<len / 2;i++){
            int t = source[len - i -1];
            source[len - i - 1] = source[i];
            source[i] = t;
        }
        return source;
    }
}
