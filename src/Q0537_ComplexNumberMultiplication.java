public class Q0537_ComplexNumberMultiplication {
    int[] num;
    int index;

    public String complexNumberMultiply(String a, String b) {
        // (a + bi)(c + di) = ac - bd + (ad + bc)i，不会出现大数
        //  0   1   2   3
        // a,b,c,d按顺序存放在数组num[]中
        num = new int[4];
        index = 0;
        getComplexNum(a);
        getComplexNum(b);
        StringBuilder res = new StringBuilder();
        int cur = num[0] * num[2] - num[1] * num[3];
        res.append(cur).append('+');
        cur = num[0] * num[3] + num[1] * num[2];
        res.append(cur).append('i');
        return res.toString();
    }

    private void getComplexNum(String a) {
        int i = 0;
        char cur;
        boolean isPositive = true;
        for (; i < a.length(); i++) {
            cur = a.charAt(i);
            if (cur == '-') {
                isPositive = false;
                continue;
            }
            if (i > 0 && cur == '+') {
                i++;
                break;
            }
            num[index] = num[index] * 10 + cur - '0';
        }
        if (!isPositive) {
            num[index] *= -1;
        }
        index++;
        isPositive = true;
        for (; i < a.length() - 1; i++) {
            cur = a.charAt(i);
            if (cur == '-') {
                isPositive = false;
                continue;
            }
            num[index] = num[index] * 10 + cur - '0';
        }
        if (!isPositive) {
            num[index] *= -1;
        }
        index++;
    }
}
