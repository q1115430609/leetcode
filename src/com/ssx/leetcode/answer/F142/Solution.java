package com.ssx.leetcode.answer.F142;

import com.ssx.util.ListNode;

public class Solution {
    public Solution(){
        ListNode l1 = new ListNode(1);
        detectCycle(l1);
    }
    // 直接遍历
    /*public ListNode detectCycle(ListNode head) {
        Set<ListNode> s = new HashSet<>();
        while(head != null){
            if(!s.add(head)){
                return head;
            }else{
                head = head.next;
            }
        }
        return null;
    }*/
    // 快慢指针执行用时快
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head,slow = head;
        while(fast != null){
            slow = slow.next;
            if(fast.next ==null){
                return null;
            }else{
                fast = fast.next.next;
            }
            if(fast == slow){
                ListNode cur = head;
                while(cur != slow){
                    cur = cur.next;
                    slow = slow.next;
                }
                return cur;
            }
        }
        return null;
    }
}
