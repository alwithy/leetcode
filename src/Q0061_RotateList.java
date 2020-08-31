public class Q0061_RotateList {
    static class ListNode {
       int val;
       ListNode next;
       public ListNode(int val) {this.val = val;}
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 0;
        ListNode cur = head;
        ListNode tail = cur;
        while (cur != null) {
            tail = cur;
            len++;
            cur = cur.next;
        }

        k = k % len;
        if (k == 0) return head;
        k = len - k - 1;
        cur = head.next;
        ListNode last = head;
        while (k > 0) {
            last = cur;
            cur = cur.next;
            k--;
        }
        last.next = null;
        tail.next = head;

        return cur;
    }
}
