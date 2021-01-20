import java.util.ArrayList;
import java.util.List;

public class Q0241_DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        //递归解决
        return diffWaysToCompute(0, input.length() - 1, input);
    }

    public List<Integer> diffWaysToCompute(int l, int r, String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> lefts = diffWaysToCompute(l, i - 1, input);
                List<Integer> rights = diffWaysToCompute(i + 1, r, input);
                for (int left : lefts) {
                    for (int right : rights) {
                        if (c == '+') {
                            res.add(left + right);
                        } else if (c == '-') {
                            res.add(left - right);
                        } else {
                            res.add(left * right);
                        }
                    }
                }
            }
        }

        //若传入的只是一个数字
        if (res.size() == 0) {
            res.add(Integer.parseInt(input.substring(l, r + 1)));
        }

        return res;
    }
}
