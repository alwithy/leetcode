import java.util.Deque;
import java.util.LinkedList;

public class Q0025_ReverseNodesInKGroup {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // 方法1，栈
    public ListNode reverseKGroup1(ListNode head, int k) {
        if (k == 1) return head;
        ListNode l = head;
        ListNode r;
        Deque<Integer> deque = new LinkedList<>();
        while (l != null) {
            r = l;
            while (deque.size() < k && r != null) {
                deque.push(r.val);
                r = r.next;
            }

            if (deque.size() < k) break;
            while (!deque.isEmpty()) {
                l.val = deque.pop();
                l = l.next;
            }
        }

        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode l = head;
        ListNode r = null, pre = null, next = null;
        int count;
        while (l != null) {
            count = 1;
            r = l;
            while (count < k && r.next != null) {
                count++;
                r = r.next;
            }

            if (count < k) break;
            if (pre != null) {
                pre.next = r;
            } else {
                head = r;
            }
            next = r.next;
            r.next = null;
            reverse(l);
            l.next = next;
            pre = l;
            l = next;
        }

        return head;
    }

    private static void reverse(ListNode head) {
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        reverseKGroup(n1, 2);
    }
}
