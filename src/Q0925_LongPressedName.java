public class Q0925_LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        // 双指针法
        if (name == null || typed == null || typed.length() < name.length()) return false;
        int p1 = 0;
        int p2 = 0;
        int len1 = name.length();
        int len2 = typed.length();
        while (p1 < len1 && p2 < len2) {
            int time1 = 1;
            char cur = name.charAt(p1);
            while (p1 + 1 < len1 && name.charAt(p1 + 1) == cur) {
                time1++;
                p1++;
            }

            int time2 = 1;
            if (cur != typed.charAt(p2)) return false;
            while (p2 + 1 < len2 && typed.charAt(p2 + 1) == cur) {
                time2++;
                p2++;
            }

            if (time1 > time2) return false;
            p1++;
            p2++;
        }

        return p1 == len1 && p2 == len2;
    }
}
