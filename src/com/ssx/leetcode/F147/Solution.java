package com.ssx.leetcode.F147;

import com.ssx.util.BornListNode;
import com.ssx.util.ListNode;

public class Solution {
    public Solution(){
        int[] a = {6,5,8,7,3,1,4,2};
        BornListNode bo = new BornListNode();
        ListNode ln = bo.bornCompListNode(a);
        ListNode cc =insertionSortList(ln);
        System.out.println(cc);
    }
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0),pre;
        dummy.next = head;
        while( head!= null && head.next!= null){
            if(head.val <= head.next.val){
                head = head.next;
                continue;
            }

            pre = dummy;
            while (pre.next.val < head.next.val) pre = pre.next;

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }
}
