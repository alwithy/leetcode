public class Q0138_CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next, copy;
        //复制节点
        while (cur != null) {
            next = cur.next;
            copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }

        //复制随机指针
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                copy = cur.next;
                copy.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //断开
        Node newHead = new Node(0);
        cur = head;
        Node p1 = newHead;//p1指向复制出的链表
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = null;
            p1.next = copy;
            p1 = p1.next;
            cur = next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {

    }
}
