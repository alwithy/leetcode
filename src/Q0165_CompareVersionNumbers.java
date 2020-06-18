public class Q0165_CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        // 大数问题
        // 两个字符串分别用双指针确认最近需要比较的数字段
        int i = 0;
        int lastI = 0;
        int j = 0;
        int lastJ = 0;
        while (i < version1.length() && j < version2.length()) {
            while (lastI < version1.length()
                    && version1.charAt(lastI) == '0')   lastI++;

            i = lastI;
            while (i < version1.length()) {
                if (version1.charAt(i) == '.')  break;
                i++;
            }

            while (lastJ < version2.length()
                    && version2.charAt(lastJ) == '0')   lastJ++;

            j = lastJ;
            while (j < version2.length()) {
                if (version2.charAt(j) == '.')  break;
                j++;
            }
            // 比较两个数字位数（从第一个非0位开始算）
            if (i - lastI > j - lastJ) {
                return 1;
            } else if (i - lastI < j - lastJ) {
                return -1;
            }
            // 位数相等时
            while (lastI < version1.length() && lastI < i
                    && lastJ < version2.length() && lastJ < j ) {
                char v1 = version1.charAt(lastI);
                char v2 = version2.charAt(lastJ);
                if (v1 > v2) {
                    return 1;
                } else if (v1 < v2) {
                    return -1;
                }

                lastI++;
                lastJ++;
            }

            i++;
            j++;
            lastI++;
            lastJ++;
        }

        if (i < version1.length()) {
            while (i < version1.length()) {
                int c = version1.charAt(i) - '0';
                if (c > 0 && c <= 9)    return 1;
                i++;
            }
        }

        if (j < version2.length()) {
            while (j < version2.length()) {
                int c = version2.charAt(j) - '0';
                if (c > 0 && c <= 9) return -1;
                j++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.0.0.0.0";
        String v2 = "1.000.000.000.00000000000";
        System.out.println(compareVersion(v1,v2));
    }
}
