import java.util.ArrayList;
import java.util.List;

public class Q0022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        // dfs算法解决
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        dfs(0, 0, n, new StringBuilder(), res);
        return res;
    }

    /**
     * @param left 剩余尚未配对的左括号数
     * @param leftUsed 已经使用过的左括号数
     * @param num 括号数
     * @param path 本次搜索已保留字符
     * @param res 结果集
     */
    private void dfs(int left,
                     int leftUsed,
                     int num,
                     StringBuilder path,
                     List<String> res) {
        if (path.length() == num * 2) {
            res.add(path.toString());
            return;
        }

        if (leftUsed < num) {
            path.append('(');
            dfs(left + 1, leftUsed + 1, num, path, res);
            path.deleteCharAt(path.length() - 1);
        }

        if (left > 0) {
            path.append(')');
            dfs(left - 1, leftUsed, num, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
