import java.util.Comparator;
import java.util.PriorityQueue;

public class Q0023_MergeKLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode head = new ListNode(0);
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new helpClass());
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode cur = head;
        while (!queue.isEmpty()) {
            ListNode l = queue.poll();
            cur.next = l;
            if (l.next != null) queue.add(l.next);
            cur.next = null;
        }
        return head.next;
    }

    static class helpClass implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }
}
