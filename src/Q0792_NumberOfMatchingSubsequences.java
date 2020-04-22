import java.util.ArrayList;

public class Q0792_NumberOfMatchingSubsequences {
    public int numMatchingSubseq1(String S, String[] words) {
        //暴力法
        if (S == null || S.length() == 0
                || words == null ||words.length == 0) {
            return 0;
        }
        int res = 0;
        char[] target = S.toCharArray();
        char[] current;
        for (int i = 0; i < words.length; i++) {
            current = words[i].toCharArray();
            if (current.length > target.length) {
                continue;
            }
            //我们依次在target中寻找current的元素
            //current中设置k来标记目前寻找的元素
            int k = 0;
            for (int j = 0; j < target.length; j++) {
                if (target[j] == current[k]) {
                    k++;
                    //如果已经找到current中所有元素，则跳出循环
                    if (k == current.length) {
                        break;
                    }
                }
            }
            if (k == current.length) {
                res++;
            }
        }
        return res;
    }

    //桶排序,官方题解
    public static int numMatchingSubseq2(String S, String[] words) {
        int res = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            heads[i] = new ArrayList<>();
        }
        //将words所有的元素按照首字母顺序放入桶中
        for (String word : words) {
            heads[word.charAt(0) - 'a'].add(new Node(word,0));
        }
        for (char c : S.toCharArray()) {
            ArrayList<Node> oldBucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<>();
            //遍历该桶中的所有元素
            for (Node node : oldBucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    res++;
                } else {
                    heads[node.word.charAt(node.index) - 'a']
                            .add(node);
                }
            }
            oldBucket.clear();
        }
        return res;
    }

    static class Node {
        String word;
        int index;

        public Node(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }
}
