import java.util.HashMap;

public class Q0166_FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "";
        }
        if (numerator == 0) {
            return "0";
        }
        long num = Math.abs(numerator);
        long denom = Math.abs((long)denominator);
        StringBuilder res = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            res.append("-");
        }
        boolean hasPoint = false;//有无小数点
        //key为被除数的值，value为对应结果在res中的索引
        HashMap<Long, Integer> map = new HashMap<>();
        while (num != 0) {
            //如果之前遇到过这个被除数，说明是循环小数
            if (map.containsKey(num)) {
                int l = map.get(num);
                res.insert(l, "(");
                res.append(")");
                break;
            }
            if (num < denom) {
                if (hasPoint) {
                    res.append("0");
                } else {
                    hasPoint = true;
                    if (res.length() == 0) {
                        res.append("0");
                    }
                    res.append(".");
                }
                map.put(num, res.length() - 1);
                num *= 10;
                continue;
            }
            long cur = num/denom;
            if (hasPoint) {
                map.put(num, res.length());
            }
            num -= denom * cur;
            res.append(cur);
            if (!hasPoint && num > 0) {
                hasPoint = true;
                res.append(".");
            }
            num *= 10;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int numerator = -1;
        int deNumerator = -2147483648;
        System.out.println(fractionToDecimal(numerator, deNumerator));
//        StringBuilder res = new StringBuilder("0123");
//        res.insert(0, "X");
//        System.out.println(res);
    }
}
