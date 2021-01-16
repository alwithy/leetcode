public class Q0211_DesignAddAndSearchWordsDataStructure {
    static class WordDictionary {
        //使用前缀树实现
        Node root;//根节点

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            Node node = root;
            node.num++;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }
                node = node.children[index];
                node.num++;
            }
            node.end++;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return false;
            }

            return search(0, word, root);
        }

        /**
         *
         * @param index 本次搜索从word[index]开始
         * @param word
         * @param node 本次搜索开始的Node
         * @return
         */
        private boolean search(int index, String word, Node node) {
            for (int i = index; i < word.length(); i++) {
                char c = word.charAt(i);

                if (c == '.') {
                    //当word最后一个字符是'.'时，只要node的children中有一个end大于0则返回true，否则false
                    //当word别的字符为'.'，就依次搜索不为null的child
                    for (Node child : node.children) {
                        if (child != null) {
                            if ((i < word.length() - 1 && search(i + 1, word, child))
                            || (i == word.length() - 1 && child.end > 0)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }

                int curIndex = c - 'a';
                if (node.children[curIndex] == null) {
                    return false;
                }
                node = node.children[curIndex];
            }
            return node.end > 0;
        }

        static class Node {
            Node[] children;
            int num;//经过这个节点的单词数量
            int end;//以这个节点为结尾的单词数量

            public Node() {
                children = new Node[26];
                num = 0;
                end = 0;
            }
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        System.out.println(wordDictionary.search("b.."));
    }
}
