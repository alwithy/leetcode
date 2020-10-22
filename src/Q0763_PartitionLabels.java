import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q0763_PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) return null;
        // 官方题解
        List<Integer> res = new LinkedList<>();
        int len = s.length();
        int[] chs = new int[26]; // 记录每个字符最后一次出现的位置
        for (int i = 0; i < len; i++) {
            chs[s.charAt(i) - 'a'] = i;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int right = 0; // 记录当前片段的右边界
        int left = -1; // 当前片段的左边界
        for (int i = 0; i < len; i++) {
            right = Math.max(right, chs[s.charAt(i) - 'a']);
            if (i == right) {
                res.add(right - left);
                left = right;
            }
        }

        return res;
    }
}
