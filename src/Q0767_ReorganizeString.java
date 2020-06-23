public class Q0767_ReorganizeString {
    public static String reorganizeString(String S) {
        if (S == null || S.length() == 0) return "";
        // chars存放各个字母出现的次数
        int[] chars = new int[26];
        for (int i = 0; i < S.length(); i++) {
            chars[S.charAt(i) - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        // left为需要填补的缝隙
        // 缝隙指的是连续元素间的空位，比如“a a a”,有两个缝隙
        // 我们把重复元素放在最后
        int left = 0;
        for (int i = 0; i < 26; i++) {
            if (chars[i] == 0) continue;
            char c = (char) ('a' + i);
            if (res.length() == 0) {
                left = chars[i] - 1;
                while (chars[i] > 0) {
                    res.append(c);
                    chars[i]--;
                }
                continue;
            }

            // 首先填充缝隙
            if (left > 0) {
                while (left > 0 && chars[i] > 0) {
                    int insert = res.length() - left;
                    res.insert(insert, c);
                    left--;
                    chars[i]--;
                }
            }

            // 从头到尾挑可以放进去的空隙
            int j = 0;
            boolean canInsert;
            while (j < res.length() && chars[i] > 0) {
                canInsert = false;
                if (j - 1 < 0) {
                    if (res.charAt(j) != c) {
                        canInsert = true;
                    }
                } else {
                    if (res.charAt(j - 1) != c && res.charAt(j) != c) {
                        canInsert = true;
                    }
                }

                if (canInsert) {
                    res.insert(j, c);
                    chars[i]--;
                    j += 2;
                } else {
                    j++;
                }
            }

            // 如果chars[i]还有剩余，放到末尾
            while (chars[i] > 0) {
                if (res.charAt(res.length() - 1) == c) {
                    left++;
                }
                res.append(c);
                chars[i]--;
            }
        }

        return left > 0 ? "" : res.toString();
    }

    public static void main(String[] args) {
        String s = "vvvlo";
        System.out.println(reorganizeString(s));
    }
}
