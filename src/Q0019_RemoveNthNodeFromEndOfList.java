public class Q0019_RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        // 双指针法
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode last = null;
        while (n > 1) {
            p2 = p2.next;
            n--;
        }
        while (p2.next != null) {
            last = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (last == null) {
            return head.next;
        }

        last.next = p1.next;
        return head;
    }
}
