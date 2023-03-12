package com.ssx.leetcode.answer.F235;

import com.ssx.util.TreeNode;

public class Solution {
    public Solution(){
        TreeNode root = new TreeNode(6);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        lowestCommonAncestor(root, p, q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currNode = root;
        while(true){
            if(currNode.val > p.val && currNode.val > q.val){
                currNode = currNode.left;
            }
            else if(currNode.val <p.val && currNode.val < q.val){
                currNode = currNode.right;
            }else{
                break;
            }
        }
        return currNode;
    }
}
