public class Q0208_PrefixTree {

    static class Trie {
        static class Node {
            Node[] children;
            int end;//以当前node作为最后一个节点的单词数量
            int num;//通过当前node的单词数量，包括end

            public Node() {
                end = 0;
                num = 0;
                children = new Node[26];
            }
        }

        Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            node.num++;
            for (int i = 0; i < word.length(); i++) {
                int curNum = word.charAt(i) - 'a';
                if (node.children[curNum] == null) {
                    node.children[curNum] = new Node();
                }
                node = node.children[curNum];
                node.num++;
            }
            node.end++;
        }

        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int curNum = word.charAt(i) - 'a';
                if (node.children[curNum] == null) {
                    return false;
                }
                node = node.children[curNum];
            }
            return node.end > 0;
        }

        public boolean startsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int curNum = prefix.charAt(i) - 'a';
                if (node.children[curNum] == null) {
                    return false;
                }
                node = node.children[curNum];
            }
            return node.num > 0;
        }
    }
}
