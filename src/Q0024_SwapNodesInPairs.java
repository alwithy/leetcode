public class Q0024_SwapNodesInPairs {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        head = head.next;
        ListNode prv = null;
        ListNode next = null;
        while (cur != null && cur.next != null) {
            if (prv != null) {
                prv.next = cur.next;
            }
            next = cur.next.next;
            cur.next.next = cur;
            cur.next = next;
            prv = cur;
            cur = cur.next;
        }

        return head;
    }
}
