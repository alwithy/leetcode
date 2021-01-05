import java.util.HashMap;

public class Q0146_LRUCache {
    static class LRUCache {

        static class Node {
            Node prv;
            Node next;
            int key;
            int value;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int capacity;//最大容量
        HashMap<Integer, Node> keyNode;
        Node head, tail;//头结点及尾结点
        //head.next是最近使用的节点

        public LRUCache(int capacity) {
            this.capacity = capacity;
            keyNode = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prv = head;
        }

        public int get(int key) {
            if (keyNode.containsKey(key)) {
                Node node = keyNode.get(key);
                moveToHead(node);
                return node.value;
            }

            return -1;
        }

        public void put(int key, int value) {
            if (keyNode.containsKey(key)) {
                Node node = keyNode.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                //若容量超过限制，则删除最不常用的节点
                if (keyNode.size() == capacity) {
                    Node remove = tail.prv;
                    removeNode(remove);
                    keyNode.remove(remove.key);
                }

                Node node = new Node(key, value);
                keyNode.put(key, node);
                addToHead(node);
            }
        }

        private void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        //从双向队列删除
        private void removeNode(Node node) {
            node.prv.next = node.next;
            node.next.prv = node.prv;
        }

        private void addToHead(Node node) {
            node.next = head.next;
            node.prv = head;
            head.next.prv = node;
            head.next = node;
        }
    }
}
