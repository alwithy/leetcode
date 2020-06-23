import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q0609_FindDuplicateFileInSystem {
    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : paths) {
            StringBuilder path = new StringBuilder();
            int i = 0;
            for (; i < s.length(); i++) {
                if (s.charAt(i) == ' ') break;
            }
            path.append(s, 0, i);
            int j = i + 1;
            while (j < s.length()) {
                int last = j;
                int k = j;
                for (; j < s.length(); j++) {
                    if (s.charAt(j) == '(') k = j;
                    if (s.charAt(j) == ' ') break;
                }
                // 左括号index为k,右括号为j - 1
                String content = s.substring(k , j);
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                StringBuilder cur = new StringBuilder(path.toString());
                map.get(content).add(cur
                        .append("/")
                        .append(s, last, k).toString());
                j++;
            }
        }
        for (List<String> list : map.values()) {
            if (list.size() > 1) res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
        List<List<String>> res = findDuplicate(strs);
    }
}
