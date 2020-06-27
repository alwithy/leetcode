public class Q0856_ScoreOfParentheses {
    public static int scoreOfParentheses(String S) {
        int res = 0;
        // left为剩余左括号的个数
        int left = 0;
        // cur为最近一层的和
        int cur = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left++;
            } else {
                left--;
                if (S.charAt(i - 1) == '(') {
                    res += Math.pow(2, left);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s));
    }
}
