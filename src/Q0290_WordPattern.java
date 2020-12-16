import java.util.HashMap;

public class Q0290_WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        if (pattern == null || pattern.length() == 0 || s == null || s.length() == 0) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(strs[i])) {
                    return false;
                }
            } else if (map.containsValue(strs[i])) {
                return false;
            } else {
                map.put(c, strs[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }
}
