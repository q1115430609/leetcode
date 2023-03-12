package com.ssx.leetcode.answer.F024;

import com.ssx.util.BornListNode;
import com.ssx.util.ListNode;

public class Solution {
    public Solution(){
        int[] lis = {1,2,3,4};
        BornListNode b = new BornListNode();
        ListNode ln = b.bornCompListNode(lis);
//        while(ln != null){
//            System.out.println(ln.val);
//            ln = ln.next;
//        }
        ListNode reList = swapPairs(ln);
        while(reList != null){
            System.out.println(reList.val);
            reList = reList.next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
