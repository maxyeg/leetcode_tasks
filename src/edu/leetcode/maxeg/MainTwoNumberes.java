package edu.leetcode.maxeg;

import edu.leetcode.maxeg.common.ListNode;
import edu.leetcode.maxeg.utils.Utils;

public class MainTwoNumberes {

    public static void main(String[] args) {
        MainTwoNumberes mtn = new MainTwoNumberes();
        ListNode n1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode n2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        Utils.output(mtn.add(n1, n2));
    }

    public ListNode add(ListNode n1, ListNode n2){
          ListNode res = new ListNode();
          ListNode cur = res;
          int extra = 0;
          while (n1 != null || n2 != null) {
              cur.val = (safeGetValue(n1) + safeGetValue(n2) + extra) % 10;
              extra = (int) Math.floor((safeGetValue(n1) + safeGetValue(n2) + extra) / 10);
              n1 = n1 != null ? n1.next : null;
              n2 = n2 != null ? n2.next : null;
              if (n1 != null || n2 != null) {
                  cur.next = new ListNode();
                  cur = cur.next;
              } else if (extra > 0) {
                  cur.next = new ListNode(extra);
                  cur = cur.next;
              }
          }
          return res;
    }

    public int safeGetValue(ListNode node) {
          return node == null ? 0 : node.val;
    }
}
