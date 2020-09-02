import java.util.HashMap;

public class Q0076_MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t == null || t.length() == 0 || s == null || s.length() == 0 || t.length() > s.length()) return "";
        // 滑动窗口
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int len = s.length();
        HashMap<Character, Integer> cur = new HashMap<>();
        for (Character c : mapT.keySet()) {
            while (r < len && cur.getOrDefault(c, 0) < mapT.get(c)) {
                if (mapT.containsKey(s.charAt(r))) {
                    cur.put(s.charAt(r), cur.getOrDefault(s.charAt(r), 0) + 1);
                }
                r++;
            }
            if (r == len) break;
        }
        // 注意此时的s(r)并没有加入窗口
        r--;

        for (Character c : mapT.keySet()) {
            if (cur.getOrDefault(c, 0) < mapT.get(c)) return "";
        }

        l = moveL(l, r, cur, mapT, s);
        int resL = l;
        int resR = r;
        int shortest = r - l + 1;
        r++;

        // 首先向右移动r，然后观察l是否能够向右移动
        while (r < len) {
            if (mapT.containsKey(s.charAt(r))) {
                cur.put(s.charAt(r), cur.get(s.charAt(r)) + 1);
            }
            l = moveL(l, r, cur, mapT, s);
            if (r - l + 1 < shortest) {
                resL = l;
                resR = r;
                shortest = r - l + 1;
            }
            r++;
        }

        return s.substring(resL, resR + 1);
    }

    private static int moveL(int l, int r, HashMap<Character, Integer> cur, HashMap<Character, Integer> mapT, String s) {
        while (l < r && (!cur.containsKey(s.charAt(l)) || cur.get(s.charAt(l)) > mapT.get(s.charAt(l)))) {
            if (cur.containsKey(s.charAt(l))) cur.put(s.charAt(l), cur.get(s.charAt(l)) - 1);
            l++;
        }

        return l;
    }

    public static void main(String[] args) {
        String s = "acbdbaab";
        String t = "aabd";
        System.out.println(minWindow(s, t));
    }
}
