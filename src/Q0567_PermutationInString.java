public class Q0567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        //滑动窗口法
        int n = s1.length();
        int m = s2.length();
        int[] c1 = new int[26]; //s1中的字符统计
        int[] c2 = new int[26]; //窗口中的字符统计
        for (int i = 0; i < n; i++) {
            c1[s1.charAt(i) - 'a']++;
        }

        //more窗口中多出的字符种类数，多出的字符指的是s1中没有并且窗口中有，或者窗口中数量比s1中数量多的字符
        //less指窗口中不足的字符种类数
        int less = 0, more = 0;
        for (int i : c1) {
            if (i > 0) {
                less++;
            }
        }

        //维持长度为n的窗口
        for (int i = 0; i < n; i++) {
            int cur = s2.charAt(i) - 'a';
            c2[cur]++;
            if (c2[cur] == c1[cur]) {
                less--;
            } else if (c2[cur] == c1[cur] + 1) {
                more++;
            }
        }

        boolean res = less == 0 && more == 0;
        for (int i = n; i < m; i++) {
            if (res) {
                break;
            }

            int add = s2.charAt(i) - 'a';
            c2[add]++;
            if (c2[add] == c1[add]) {
                less--;
            } else if (c2[add] == c1[add] + 1) {
                more++;
            }
            int remove = s2.charAt(i - n) - 'a';
            c2[remove]--;
            if (c2[remove] == c1[remove]) {
                more--;
            } else if (c2[remove] == c1[remove] - 1) {
                less++;
            }

            res = less == 0 && more == 0;
        }

        return res;
    }
}
