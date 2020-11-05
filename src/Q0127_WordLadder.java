import java.util.*;

public class Q0127_WordLadder {
    static boolean flag;

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0
                || endWord == null || endWord.length() == 0
                || wordList == null || wordList.size() == 0
                || beginWord.equals(endWord)) {
            return 0;
        }
        // 双向广度优先搜索，分别从beginWord和endWord出发，每次选择待访问列表短的一方进行推进
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        // 建表
        HashMap<String, List<String>> dic = new HashMap<>();
        buildMap(dic, wordSet);
        List<String> beginList = new LinkedList<>();
        HashSet<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);
        // 将beginWord能变成的单词加入列表
        StringBuilder sb = new StringBuilder(beginWord);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, '*');
            String str = sb.toString();
            if (dic.containsKey(str)) {
                List<String> cur = dic.get(str);
                for (String s : cur) {
                    if (s.equals(endWord)) return 2; // 此时只变换了1次
                    if (!beginVisited.contains(s)) {
                        beginList.add(s);
                    }
                }
            }
            sb.setCharAt(i, c);
        }
        List<String> endList = new LinkedList<>();
        HashSet<String> endVisited = new HashSet<>();
        endList.add(endWord);
        flag = false;
        int res = 1;
        // 开始广度优先遍历
        out:
        while (!beginList.isEmpty() && !endList.isEmpty()) {
            res++;
            List<String> nextList = new LinkedList<>();
            if (beginList.size() < endList.size()) {
                for (String s : beginList) {
                    beginVisited.add(s);
                    visit(s, dic, beginVisited, endVisited, nextList);
                    if (flag) break out;
                }
                beginList = nextList;
            } else {
                for (String s : endList) {
                    endVisited.add(s);
                    visit(s, dic, endVisited, beginVisited, nextList);
                    if (flag) break out;
                }
                endList = nextList;
            }
        }

        return flag? res : 0;
    }

    public static void buildMap(HashMap<String, List<String>> dic, HashSet<String> wordSet) {
        for (String s : wordSet) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                char c = sb.charAt(i);
                sb.setCharAt(i, '*');
                String str = sb.toString();
                if (!dic.containsKey(str)) {
                    List<String> cur = new LinkedList<>();
                    cur.add(s);
                    dic.put(str, cur);
                } else {
                    dic.get(str).add(s);
                }
                sb.setCharAt(i, c);
            }
        }
    }

    public static void visit(String s, HashMap<String, List<String>> dic,
                             HashSet<String> curVisited, HashSet<String> otherVisited,
                             List<String> nextList) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, '*');
            String str = sb.toString();
            sb.setCharAt(i, c);
            List<String> cur = dic.get(str);
            for (String nextVisit : cur) {
                if (otherVisited.contains(nextVisit)) {
                    flag = true;
                    return;
                }

                if (!curVisited.contains(nextVisit)) {
                    nextList.add(nextVisit);
                }
            }
        }


    }

    public static void main(String[] args) {
        String beginWord1 = "hit";
        String endWord1 = "cog";
        String[] strs1 = {"hot","dot","dog", "lot", "log", "cog"};
        List<String> wordList1 = new LinkedList<>(Arrays.asList(strs1));
        System.out.println(ladderLength(beginWord1, endWord1, wordList1));
        String beginWord2 = "hot";
        String endWord2 = "dog";
        String[] strs2 = {"hot","dot","dog"};
        List<String> wordList2 = new LinkedList<>(Arrays.asList(strs2));
        System.out.println(ladderLength(beginWord2, endWord2, wordList2));
    }
}
