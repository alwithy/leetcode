import java.util.DoubleSummaryStatistics;

public class Q0318_MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) {
            return 0;
        }
        //位运算
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];
        int mask;
        for (int i = 0; i < n; i++) {
            String word = words[i];
            mask = 0;
            for (int j = 0; j < word.length(); j++) {
                mask |= getBit(word.charAt(j));
            }
            masks[i] = mask;
            lens[i] = word.length();
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(lens[i] * lens[j], res);
                }
            }
        }

        return res;
    }

    public int getBit(char c) {
        return 1 << (c - 'a');
    }
}
