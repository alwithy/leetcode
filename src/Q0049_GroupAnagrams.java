import java.util.*;

public class Q0049_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        int[] count = new int[26];
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            Arrays.fill(count, 0);

            for (char c : s.toCharArray()) count[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                sb.append("#");
                sb.append(String.valueOf(count[i]));
            }

            String str = sb.toString();
            if (!map.containsKey(str)) map.put(str, new ArrayList<>());
            map.get(str).add(s);
        }

        return new ArrayList<>(map.values());
    }


}
