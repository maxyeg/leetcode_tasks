package edu.leetcode.maxeg.linkedlist;

import edu.leetcode.maxeg.common.ListNode;

import java.util.Stack;

import static edu.leetcode.maxeg.utils.Utils.*;

public class MaxTwinSumLnkdLst {
    public static void main(String[] args) {
        MaxTwinSumLnkdLst main = new MaxTwinSumLnkdLst();
        output(main.pairSum(createLinkedList(new int[]{5,4,2,1})));
        output(main.pairSum(createLinkedList(new int[]{4,2,2,3})));
        output(main.pairSum(createLinkedList(new int[]{4,2,1,2,3})));
    }

    public int pairSum(ListNode head) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        ListNode ptr = head;
        int length = 0;
        while (ptr != null) {
            length++;
            stack.push(ptr.val);
            ptr = ptr.next;
        }
        ptr = head;
        int i = 0;
        while (i < (length / 2)) {
            i++;
            int twin = stack.pop();
            if (ptr.val + twin > max) {
                max = ptr.val + twin;
            }
            ptr = ptr.next;
        }
        return max;
    }

}
