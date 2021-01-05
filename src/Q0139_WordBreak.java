import java.util.HashSet;
import java.util.List;

public class Q0139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> words = new HashSet<>(wordDict);
        int n = s.length();
        //dp[i]表示s[0..i - 1]能否被分成单词表中的单词
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i - j] && words.contains(s.substring(i - j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
