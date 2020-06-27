import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q0916_WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        int[] charB = new int[26];
        for (int i = 0; i < B.length; i++) {
            int[] cur = new int[26];

            for (int j = 0; j < B[i].length(); j++) {
                char c = B[i].charAt(j);
                cur[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                charB[j] = Math.max(charB[j], cur[j]);
            }
        }

        for (String a : A) {
            int[] curA = new int[26];
            for (int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                curA[c - 'a']++;
            }

            boolean isSubset = true;
            for (int i = 0; i < 26; i++) {
                if (curA[i] < charB[i]) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) res.add(a);
        }

        return res;
    }

}
