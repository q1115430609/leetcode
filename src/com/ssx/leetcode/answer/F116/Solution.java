package com.ssx.leetcode.answer.F116;

import com.ssx.util.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public Solution(){
        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.left.left = new Node(4);
        n1.left.right = new Node(5);
        n1.right.left = new Node(6);
        n1.right.right = new Node(7);
        connect(n1);
    }
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i =0;i<size;i++){
                Node node = queue.poll();
                if(i<size - 1){
                    node.next = queue.peek();
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }

        }
        return root;
    }

}
