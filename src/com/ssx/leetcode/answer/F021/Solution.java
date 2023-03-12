package com.ssx.leetcode.answer.F021;

import com.ssx.util.ListNode;

public class Solution {
    public Solution(){
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;

        ListNode ln4 = new ListNode(1);
        ListNode ln5 = new ListNode(3);
        ListNode ln6 = new ListNode(4);

        ln4.next = ln5;
        ln5.next = ln6;

        ListNode result = mergeTwoLists(ln1, ln4);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        else if(l2 == null){
            return l1;
        }else{
          if(l1.val < l2.val){
              ListNode ch = l1.next;
              l1.next = mergeTwoLists(ch,l2);
              return l1;
          }else{
              ListNode ch = l2.next;
              l2.next = mergeTwoLists(l1,ch);
              return l2;
          }
        }

    }
}
