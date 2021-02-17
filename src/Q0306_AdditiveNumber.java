public class Q0306_AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        //DFS
        return dfs(0, num, 0, 0, 0);
    }

    /**
     *
     * @param index 本次搜索开始的索引
     * @param s 数字字符串
     * @param count 已经分割出的数字数量
     * @param sum 前两个数字和
     * @param last 之前一个数字
     * @return 是否能成功分割
     */
    public static boolean dfs(int index, String s, int count, long sum, long last) {
        if (index == s.length()) {
            return count >= 3;
        }

        //若第一个数字为0，则这个数字只能分割为0
        if (s.charAt(index) == '0') {
            if (count < 2) {
                return dfs(index + 1, s, count + 1, sum, 0);
            } else {
                if (sum == 0) {
                    return dfs(index + 1, s, count + 1, 0, 0);
                } else {
                    return false;
                }
            }
        }

        long cur = 0;
        for (int i = index; i < s.length(); i++) {
            cur = cur * 10 + s.charAt(i) - '0';


            if (count < 2) {
                if (dfs(i + 1, s, count + 1, sum + cur, cur)) {
                    return true;
                }
            } else {
                if (cur > sum) {
                    break;
                }

                if (cur == sum) {
                    if (dfs(i + 1, s, count + 1, cur + last, cur)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "000000";
        System.out.println(isAdditiveNumber(s));
    }
}
