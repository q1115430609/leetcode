package com.ssx.leetcode.answer.F530;

import com.ssx.util.TreeNode;

public class Solution {
    int min;
    int pre;
    public Solution(){
        TreeNode l1 = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(6);
        TreeNode l7 = new TreeNode(7);
        TreeNode l8 = new TreeNode(8);
        TreeNode l9 = new TreeNode(9);
        TreeNode l10 = new TreeNode(10);
        TreeNode l11 = new TreeNode(11);
        TreeNode l12 = new TreeNode(12);

        l8.left = l4;
        l4.left = l2;
        l2.left = l1;
        l2.right = l3;
        l4.right = l6;
        l6.left = l5;
        l6.right = l7;
        l8.right = l12;
        l12.left = l10;
        l10.left = l9;
        l10.right = l11;
        getMinimumDifference(l8);
    }
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return min;
    }
    public void dfs(TreeNode l){
        if(l == null){
            return ;
        }
        dfs(l.left);
        System.out.println(l.val);
        if(pre == -1){
            pre = l.val;
        }else{
            min = Math.min(l.val - pre,min);
            pre = l.val;
        }
        dfs(l.right);
    }
}
