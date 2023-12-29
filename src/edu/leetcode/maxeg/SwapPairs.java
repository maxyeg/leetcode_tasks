package edu.leetcode.maxeg;

import edu.leetcode.maxeg.common.ListNode;

public class SwapPairs {

    public static void main(String[] args) {
        SwapPairs sp = new SwapPairs();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        sp.swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        ListNode newlist = new ListNode();
        ListNode newlistCurrent = newlist;
        while (current != null && current.next != null) {
            newlistCurrent.val = current.next.val;
            newlistCurrent.next = new ListNode(current.val);
            current = current.next.next;
            if (current != null) newlistCurrent.next.next = new ListNode();
            newlistCurrent = newlistCurrent.next.next;
        }
        if (current != null) {
            newlistCurrent.val = current.val;
        }
        return newlist;
    }
}
