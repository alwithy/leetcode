import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q0030_SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        // 滑动窗口思想
        int len = words[0].length();
        int wordNum = words.length;
        HashMap<String, Integer> allWords = new HashMap<>();
        for (String str : words) {
            allWords.put(str, allWords.getOrDefault(str, 0) + 1);
        }

        int num;
        for (int i = 0; i <= s.length() - wordNum * len; i++) {
            HashMap<String, Integer> findWords = new HashMap<>();
            num = 0;
            for (int j = 0; j < wordNum; j++) {
                String str = s.substring(i + j * len, i + (j + 1) * len);
                if (!allWords.containsKey(str)
                        || findWords.getOrDefault(str, 0) + 1 > allWords.get(str)) {
                    break;
                }
                findWords.put(str, findWords.getOrDefault(str, 0) + 1);
                num++;
            }

            if (num == wordNum) res.add(i);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> res = findSubstring(s, words);
    }
}
