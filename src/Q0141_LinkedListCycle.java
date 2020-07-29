public class Q0141_LinkedListCycle {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        // 双指针法
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != p2 && p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1 == p2;
    }
}
