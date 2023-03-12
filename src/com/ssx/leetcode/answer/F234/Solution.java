package com.ssx.leetcode.answer.F234;

import com.ssx.util.BornListNode;
import com.ssx.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Solution(){
        BornListNode bo = new BornListNode();
        int[] a = {0,0};
        ListNode l =bo.bornCompListNode(a);
        isPalindrome(l);
    }
    public boolean isPalindrome(ListNode head) {
        List<ListNode> li = new ArrayList<>();
        while(head != null){
            li.add(head);
            head = head.next;
        }
        int size = li.size();
        for(int i =0;i<size/2;i++){
            if(li.get(i).val != li.get(size -1 - i).val){
                return false;
            }
        }
        return true;
    }
}
