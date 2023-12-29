package edu.leetcode.maxeg.linkedlist;

import edu.leetcode.maxeg.common.ListNode;
import edu.leetcode.maxeg.utils.Utils;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        DeleteMiddleNode dmn = new DeleteMiddleNode();
        Utils.output(dmn.deleteMiddle(Utils.createLinkedList(new int[]{1})));
        Utils.output(dmn.deleteMiddle(Utils.createLinkedList(new int[]{1,3,4,7,1,2,6})));
        Utils.output(dmn.deleteMiddle(Utils.createLinkedList(new int[]{1,2,3,4})));
        Utils.output(dmn.deleteMiddle(Utils.createLinkedList(new int[]{2,1})));
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        int length = 1;
        ListNode ptr = head;
        while (ptr.next != null) {
            length++;
            ptr = ptr.next;
        }
        ptr = head;
        int i;
        for (i = 0; i < Math.floor(length / 2) - 1; i++) {
            ptr = ptr.next;
        }
        if (i + 2 <= length) {
            ptr.next = ptr.next.next;
        } else {
            ptr.next = null;
        }
        return head;
    }

}
