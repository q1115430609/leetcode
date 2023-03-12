package com.ssx.leetcode.answer.F141;

import com.ssx.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public Solution(){
        ListNode l1 = new ListNode(1);
        hasCycle(l1);
    }
    public boolean hasCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        while(head != null){
            if(!s.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
