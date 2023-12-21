import java.util.List;

public class SwapPairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val) {this.val = val;};
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    (next != null ? ", next=" + next.toString() : "") +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        swapPairs(head);
    }

    public static ListNode swapPairs(ListNode head) {
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
