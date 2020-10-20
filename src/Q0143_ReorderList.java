import java.util.Deque;
import java.util.LinkedList;

public class Q0143_ReorderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode h1 = new ListNode(0);
        h1.next = head;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        Deque<ListNode> deque = new LinkedList<>();
        ListNode next = p1.next;
        p1.next = null;
        p1 = next;
        while (p1 != null) {
            deque.push(p1);
            next = p1.next;
            p1.next = null;
            p1 = next;
        }

        p1 = h1.next;
        while (!deque.isEmpty()) {
            ListNode cur = deque.pop();
            next = p1.next;
            p1.next = cur;
            cur.next = next;
            p1 = next;
        }
    }
}
