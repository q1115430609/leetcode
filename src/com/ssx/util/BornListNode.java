package com.ssx.util;

public class BornListNode {
    public ListNode bornCompListNode(int[] lis){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i =0;i<lis.length;i++){
            ListNode ln = new ListNode(lis[i]);
            cur.next = ln;
            cur = cur.next;
        }
        return head.next;
    }
}
