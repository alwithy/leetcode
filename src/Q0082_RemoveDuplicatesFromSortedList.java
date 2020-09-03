public class Q0082_RemoveDuplicatesFromSortedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        int val = head.val;
        if (head.next.val == val) {
            while (head.next != null && head.next.val == val) {
                head = head.next;
            }
            res.next = deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }

        return res.next;
    }
}
