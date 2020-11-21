public class Q0148_SortList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //官方题解，自底向上归并排序
        int len = 0;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        for (int subLen = 1; subLen < len; subLen <<= 1) {
            ListNode prv = newHead, cur = newHead.next;
            while (cur != null) {
                ListNode head1 = cur;
                for (int i = 1; i < subLen && cur.next != null; i++) {
                    cur = cur.next;
                }
                ListNode head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLen && cur != null; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                //merge
                ListNode merge = merge(head1, head2);
                prv.next = merge;
                while (prv.next != null) {
                    prv = prv.next;
                }
                cur = next;
            }
        }

        return newHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode newHead = new ListNode(0);
        ListNode prv = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                prv.next = head1;
                head1 = head1.next;
            } else {
                prv.next = head2;
                head2 = head2.next;
            }
            prv = prv.next;
            prv.next = null;
        }
        if (head1 != null) {
            prv.next = head1;
        } else {
            prv.next = head2;
        }
        return newHead.next;
    }
}
