public class Q328_OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = new ListNode(0);
        ListNode p1 = odd;
        ListNode even = new ListNode(0);
        ListNode p2 = even;
        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            p1.next = head;
            p1 = p1.next;
            p2.next = head.next;
            p2 = p2.next;
            p1.next = null;
            p2.next = null;
            head = next;
        }
        if (head != null) {
            p1.next = head;
            p1 = p1.next;
        }
        p1.next = even.next;
        return odd.next;
    }
}
