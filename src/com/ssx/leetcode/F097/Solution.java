package com.ssx.leetcode.F097;

import com.ssx.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public Solution(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        inorderTraversal(root);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode head = root;
        List<Integer> list = new ArrayList<>();
        //orderList(root,list);
        queOrder(root,list);
        return list;
    }
    // 一： 递归
    public void orderList(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        orderList(root.left,list);
        list.add(root.val);
        orderList(root.right,list);
    }
    // 二： 栈
    public List<Integer> queOrder(TreeNode root,List<Integer> list){
        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
