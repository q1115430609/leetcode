package com.ssx.leetcode.F328;

import com.ssx.util.ListNode;

public class Solution {
    public Solution(){

    }
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode evenNode = head;
        ListNode oddNode = head.next;
        ListNode oddHeadNode = oddNode;
        while(evenNode.next != null && oddNode.next != null){
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
            oddNode.next = evenNode.next;
            oddNode = evenNode.next;
        }
        evenNode.next = oddHeadNode;
        return head;
    }
}
