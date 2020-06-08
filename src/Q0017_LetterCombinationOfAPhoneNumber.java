import java.util.ArrayList;
import java.util.List;

public class Q0017_LetterCombinationOfAPhoneNumber {
    char[][] letter = {{},{},{'a','b','c'},{'d','e','f'},
            {'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        // dfs算法
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        dfs(digits, 0, new StringBuilder(), res);

        return res;
    }

    /**
     * @param digits 本次使用的字符串
     * @param index 开始搜索的索引
     * @param path 本次搜索已经保留的字母
     * @param res 结果集
     * */
    private void dfs(String digits,
                     int index,
                     StringBuilder path,
                     List<String> res) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }

        int num = digits.charAt(index) - '0';
        for (int i = 0; i < letter[num].length; i++) {
            path.append(letter[num][i]);
            dfs(digits,index + 1, path, res);
            path.deleteCharAt(index);
        }
    }
}
