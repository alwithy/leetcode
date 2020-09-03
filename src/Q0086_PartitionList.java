public class Q0086_PartitionList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode l = new ListNode(0);
        ListNode lLast = l;
        ListNode r = new ListNode(0);
        ListNode rLast = r;
        while (head != null) {
            if (head.val < x) {
                lLast.next = head;
                lLast = lLast.next;
            } else {
                rLast.next = head;
                rLast = rLast.next;
            }

            ListNode next = head.next;
            head.next = null;
            head = next;
        }

        if (lLast == l) {
            return r.next;
        } else {
            lLast.next = r.next;
            return l.next;
        }
    }
}
