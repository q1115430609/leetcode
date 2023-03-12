package com.ssx.leetcode.answer.F231;

public class Solution {
    public Solution() {
        boolean flag = isPowerOfTwo(3);
        System.out.printf("ddd：" + flag);
    }

    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n == 0) return false;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }
}
