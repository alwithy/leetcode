import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q0890_FindAndReplacePattern {
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isSamePattern(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private static boolean isSamePattern(String word, String pattern) {
        // pw为pattern到word字母的映射
        // wp为pattern到word
        HashMap<Character, Character> pw = new HashMap<>();
        HashMap<Character, Character> wp = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);
            if (!pw.containsKey(p) && !wp.containsKey(w)) {
                pw.put(p, w);
                wp.put(w, p);
            } else {
                if ((pw.containsKey(p) && pw.get(p) != w)
                        || (wp.containsKey(w) && wp.get(w) != p)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        List<String> res = findAndReplacePattern(words, pattern);
    }
}
