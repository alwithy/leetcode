public class Q0092_ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {this.val = val;}
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode last = res;
        for (int i = 1; i < m; i++) {
            last = head;
            head = head.next;
        }
        last.next = null;
        ListNode r = head;
        ListNode l = null;
        ListNode next;
        for (int i = m; i <= n; i++) {
            next = head.next;
            head.next = l;
            l = head;
            head = next;
        }
        last.next = l;
        r.next = head;
        return res.next;
    }
}
