import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q1178_NumberOfValidWordsForEachPuzzle {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        //官方题解1，枚举子集
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                mask |= (1 << (word.charAt(i) - 'a'));
            }

            if (Integer.bitCount(mask) <= 7) {
                map.put(mask, map.getOrDefault(mask, 0) + 1);
            }
        }

        for (String s : puzzles) {
            int mask = 0;
            for (int i = 1; i < 7; i++) {
                mask |= (1 << (s.charAt(i) - 'a'));
            }

            int count = 0;
            int subset = mask;
            int first = 1 << (s.charAt(0) - 'a');
            while (subset != 0) {
                int sub = subset | first;
                if (map.containsKey(sub)) {
                    count += map.get(sub);
                }
                subset = (subset - 1) & mask;
            }

            //当一个word只由puzzle的首字母组成时

            if (map.containsKey(first)) {
                count += map.get(first);
            }
            res.add(count);
        }

        return res;
    }
}
