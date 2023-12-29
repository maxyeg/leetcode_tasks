package edu.leetcode.maxeg.linkedlist;

import edu.leetcode.maxeg.common.ListNode;

import static edu.leetcode.maxeg.utils.Utils.createLinkedList;
import static edu.leetcode.maxeg.utils.Utils.output;

public class ReverseLnkdLst {
    public static void main(String[] args) {
        ReverseLnkdLst rll = new ReverseLnkdLst();
        output(rll.reverseList(createLinkedList(new int[]{1,2})));
        output(rll.reverseList(createLinkedList(new int[]{})));
        output(rll.reverseList(createLinkedList(new int[]{1,2,3,4,5})));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.next.next == null) {
            ListNode tmp = head.next;
            head.next = null;
            tmp.next = head;
            head = tmp;
        } else {
            ListNode tmp = reverseList(head.next);
            head.next = null;
            ListNode ptr = tmp;
            while (ptr.next != null) { ptr = ptr.next; }
            ptr.next = head;
            head = tmp;
        }
        return head;
    }
}
