import java.util.ArrayList;
import java.util.List;

public class Q0816_AmbiguousCoordinates {
    public static List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        String s = S.substring(1, S.length() - 1);
        // 先把字符串数字部分分割成两部分，再分别对两部分进行加小数点处理
        // 1.首位和尾部都是0，那么无论如何都不能满足要求，pass
        // 2.首位是0，那么那么只能是0.xxxxx
        // 3.尾部是0，那么只能出现xxxxx0
        // 4.其余情况则是按位加小数点再加其本身
        // 上面的情况都是考虑当前串长度大于1的情况

        for (int i = 1; i < s.length(); i++) {
            String s1 = s.substring(0,i);
            String s2 = s.substring(i);
            List<String> split1 = split(s1);
            List<String> split2 = split(s2);
            if (!split1.isEmpty() && !split2.isEmpty()) {
                for (String str1 : split1) {
                    for (String str2 : split2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("(").append(str1).append(",")
                                .append(str2).append(")");
                        res.add(sb.toString());
                    }
                }
            }
        }

        return res;
    }

    private static List<String> split(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) return res;

        if (s.length() == 1) {
            res.add(s);
            return res;
        }

        // s长度大于1的情况
        if (s.charAt(0) == '0') {
            if (s.charAt(s.length() - 1) == '0') {
                return res;
            }
            StringBuilder sb = new StringBuilder().append("0.")
                    .append(s.substring(1));
            res.add(sb.toString());
        } else if (s.charAt(s.length() - 1) == '0') {
            res.add(s);
        } else {
            // 此时每个位置都能加小数点
            StringBuilder sb;
            for (int i = 1; i < s.length(); i++) {
                sb = new StringBuilder()
                        .append(s.substring(0,i))
                        .append(".")
                        .append(s.substring(i));
                res.add(sb.toString());
            }
            res.add(s);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "(123)";
        List<String> res = ambiguousCoordinates(s);
    }
}
