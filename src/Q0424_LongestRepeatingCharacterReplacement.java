public class Q0424_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        //滑动窗口法
        int[] chs = new int[26];
        int max = 0;
        int left = 0, right = 0;//滑动窗口的范围为[left..right]
        while (right < s.length()) {
            int r = s.charAt(right) - 'A';
            chs[r]++;
            //判断最多的字母数量是否发生改变
            max = Math.max(max, chs[r]);
            if (right - left + 1 - max > k) {
                chs[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }

        return right - left;
    }
}
