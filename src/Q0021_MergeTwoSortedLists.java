public class Q0021_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 双指针法
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = null;
        if (p1.val <= p2.val) {
            head = new ListNode(p1.val);
            p1 = p1.next;
        } else {
            head = new ListNode(p2.val);
            p2 = p2.next;
        }

        ListNode cur = head;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                cur.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                cur.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            cur = cur.next;
        }

        while (p1 != null) {
            cur.next = new ListNode(p1.val);
            p1 = p1.next;
            cur = cur.next;
        }

        while (p2 != null) {
            cur.next = new ListNode(p2.val);
            p2 = p2.next;
            cur = cur.next;
        }

        return head;
    }
}
