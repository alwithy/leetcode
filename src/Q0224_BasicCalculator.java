public class Q0224_BasicCalculator {
    public static int calculate(String s) {
        //递归解决
        return calculate(s, 0, false).val;
    }

    //isPar表示是否是括号内的内容
    public static ReturnData calculate(String s, int i, boolean isPar) {
        int val = 0;//当前数字
        int notion = 1;//符号
        int sum = 0;//已经计算的部分的值

        while (i < s.length()) {
            if (isPar && s.charAt(i) == ')') {
                break;
            }

            if (s.charAt(i) == '(') {
                ReturnData rt = calculate(s, i + 1, true);
                sum += rt.val * notion;
                notion = 1;
                i = rt.index + 1;
            } else if (s.charAt(i) == '+') {
                notion = 1;
                i++;
            } else if (s.charAt(i) == '-') {
                notion = -1;
                i++;
            } else if (s.charAt(i) == ' ') {
              i++;
            } else {
                val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + s.charAt(i) - '0';
                    i++;
                }
                sum += val * notion;
                notion = 1;
            }
        }

        return new ReturnData(i, sum);
    }

    static class ReturnData {
        int index;
        int val;

        public ReturnData(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate("1+1"));
    }
}
