package edu.leetcode.maxeg.linkedlist;

import edu.leetcode.maxeg.common.ListNode;
import edu.leetcode.maxeg.utils.Utils;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        Utils.output(oddEvenLinkedList.oddEvenList(Utils.createLinkedList(new int[]{1,2,3,4,5,6,7,8})));
        Utils.output(oddEvenLinkedList.oddEvenList(Utils.createLinkedList(new int[]{1,2,3,4,5})));
        Utils.output(oddEvenLinkedList.oddEvenList(Utils.createLinkedList(new int[]{2,1,3,5,6,4,7})));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddPtr = head, evenHead = new ListNode(head.next.val), evenPtr = evenHead;
        while (oddPtr.next != null) {
            oddPtr.next = oddPtr.next.next;
            if (oddPtr.next != null) {
                if (oddPtr.next.next != null) {
                    evenPtr.next = new ListNode(oddPtr.next.next.val);
                    evenPtr = evenPtr.next;
                }
                oddPtr = oddPtr.next;
            }
        }
        oddPtr.next = evenHead;
        return head;
    }

}
