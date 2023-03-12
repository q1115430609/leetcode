package com.ssx.leetcode.answer.F143;

import com.ssx.util.BornListNode;
import com.ssx.util.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public Solution(){
        int[] a = {1,2,3,4};
        BornListNode bn = new BornListNode();
        ListNode li = bn.bornCompListNode(a);
//        while(li != null){
//            System.out.println(li.val);
//            li = li.next;
//        }
        reorderList(li);
    }
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode reH = head;
        List<ListNode> lis = new ArrayList<>();
        while(reH != null){
            lis.add(reH);
            reH = reH.next;
        }
        int i = 0,j = (lis.size() - 1);
        while(i<j){
            lis.get(i).next = lis.get(j);
            i++;
            if(i>=j){
                break;
            }
            lis.get(j).next = lis.get(i);
            j--;
        }
        lis.get(i).next = null;
    }
}
