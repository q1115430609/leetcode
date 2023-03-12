package com.ssx.leetcode.answer.F002;

import com.ssx.util.ListNode;

public class Solution {
    public Solution(){
        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(8);
//        ListNode l3 = new ListNode(3);
//        l1.next = l2;
//        l2.next = l3;
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
//        ListNode l6 = new ListNode(4);
        l4.next = l5;
//        l5.next= l6;
        ListNode n = addTwoNumbers(l1,l4);
        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        int num = 0;
        ListNode c = head;
        while (l1 != null || l2 != null){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + num;
            c.next = new ListNode(sum % 10);
            num = sum / 10;
            c = c.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(num > 0){
            c.next = new ListNode(num);
        }
        return head.next;
    }


}
