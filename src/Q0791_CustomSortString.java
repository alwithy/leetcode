import java.util.HashMap;

public class Q0791_CustomSortString {
    public String customSortString(String S, String T) {
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(i, S.charAt(i));
        }

        int[] arr = new int[26];
        for (int i = 0; i < T.length(); i++) {
            arr[T.charAt(i) - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        // 先放入S中有的字符
        for (int i = 0; i < map.keySet().size(); i++) {
            char c = map.get(i);
            while (arr[c - 'a'] > 0) {
                res.append(c);
                arr[c - 'a']--;
            }
        }

        // 再放入剩下的字符
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0) {
                res.append((char) (i + 'a'));
                arr[i]--;
            }
        }

        return res.toString();
    }
}
