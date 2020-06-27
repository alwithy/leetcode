import java.util.Arrays;
import java.util.HashMap;

public class Q0833_FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder res = new StringBuilder();
        // 双指针法，i指向S，j指向indexs
        // 先判断是否替换，然后再拼接起来
        // 注意数组越界的问题
        HashMap<Integer, String[]> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], new String[]{sources[i], targets[i]});
        }
        int len;
        String source, target;
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(i)) {
                res.append(S.charAt(i));
                continue;
            }

            source = map.get(i)[0];
            target = map.get(i)[1];
            if (source.equals(S.substring(i, i + source.length()))) {
                res.append(target);
                i += source.length() - 1;
            } else {
                res.append(S.charAt(i));
            }
        }

        return res.toString();
    }
}
