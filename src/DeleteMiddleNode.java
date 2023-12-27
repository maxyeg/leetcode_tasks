public class DeleteMiddleNode {
    public static void main(String[] args) {
        DeleteMiddleNode dmn = new DeleteMiddleNode();
        Utils.output(dmn.deleteMiddle(dmn.createLinkedList(new int[]{1})));
        Utils.output(dmn.deleteMiddle(dmn.createLinkedList(new int[]{1,3,4,7,1,2,6})));
        Utils.output(dmn.deleteMiddle(dmn.createLinkedList(new int[]{1,2,3,4})));
        Utils.output(dmn.deleteMiddle(dmn.createLinkedList(new int[]{2,1})));
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

    private ListNode createLinkedList(int[] ints) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < ints.length - 1; i++) {
            cur.val = ints[i];
            cur.next = new ListNode();
            cur = cur.next;
        }
        cur.val = ints[ints.length - 1];
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "LN{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
