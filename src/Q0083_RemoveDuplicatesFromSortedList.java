public class Q0083_RemoveDuplicatesFromSortedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                ListNode next = cur.next;
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }

                cur.next = next;
                cur = next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
