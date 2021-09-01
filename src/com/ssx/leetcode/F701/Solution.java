package com.ssx.leetcode.F701;

import com.ssx.util.TreeNode;

public class Solution {
    public Solution(int val){

    }
    public Solution(){
        TreeNode n1 = new TreeNode(4);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(7);
        n1.left.left = new TreeNode(1);
        n1.left.right = new TreeNode(3);
        n1.right = new TreeNode(7);
        TreeNode n = insertIntoBST(n1, 5);
    }
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if(root == null){
//            return new TreeNode(val);
//        }
//        if(root.val > val){
//            root.left = insertIntoBST(root.left,val);
//        }else{
//            root.right = insertIntoBST(root.right,val);
//        }
//        return root;
//    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode head = root;
        TreeNode curr = root;
        if(root == null){
            return new TreeNode(val);
        }
        while(true){
            if(curr.val > val){
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    TreeNode newT = new TreeNode(val);
                    curr.left = newT;
                    break;
                }
            }else{
                if(curr.right != null){
                    curr = curr.right;
                }else{
                    TreeNode newT = new TreeNode(val);
                    curr.right = newT;
                    break;
                }
            }
        }
        return head;
    }
}
