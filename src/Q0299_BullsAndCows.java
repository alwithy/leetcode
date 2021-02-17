public class Q0299_BullsAndCows {
    public String getHint(String secret, String guess) {
        //secret中多余的数字
        int[] n1 = new int[10];
        //guess中多余的数字
        int[] n2 = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int c1 = secret.charAt(i) - '0';
            int c2 = guess.charAt(i) - '0';
            if (c1 == c2) {
                bulls++;
            } else {
                n1[c1]++;
                n2[c2]++;
            }
        }

        for (int i = 0; i < n1.length; i++) {
            cows += Math.min(n1[i], n2[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
