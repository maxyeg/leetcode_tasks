package edu.leetcode.maxeg.utils;

import edu.leetcode.maxeg.binarytree.common.TreeNode;
import edu.leetcode.maxeg.common.ListNode;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class Utils {
    public static <T> void output(T object) {
        Consumer<T> output = System.out::println;
        if (object != null && object.getClass().isArray() ) {
            int length = Array.getLength(object);
            if (length == 0) {
                System.out.print("[]");
            } else {
                System.out.print("[");
                for (int i = 0; i < length - 1; i++) {
                    System.out.print(Array.get(object, i) + ", ");
                }
                System.out.print(Array.get(object, length - 1));
                System.out.println("]");
            }
        } else {
            output.accept(object);
        }
    }

    public static ListNode createLinkedList(int[] ints) {
        ListNode head = new ListNode();
        if (ints.length > 0) {
            ListNode cur = head;
            for (int i = 0; i < ints.length - 1; i++) {
                cur.val = ints[i];
                cur.next = new ListNode();
                cur = cur.next;
            }
            cur.val = ints[ints.length - 1];
        }
        return head;
    }

    public static TreeNode constructBinaryTree(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(nums.get(0));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < nums.size()) {
            TreeNode curr = q.poll();
            if (i < nums.size() && nums.get(i) != null) {
                curr.left = new TreeNode(nums.get(i));
                q.add(curr.left);
            }
            i++;
            if (i < nums.size() && nums.get(i) != null) {
                curr.right = new TreeNode(nums.get(i));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}
