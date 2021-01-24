public class Q5662_ChangeMinimumCharactersToSatisfy {
    public static int minCharacters(String a, String b) {
        int res = Integer.MAX_VALUE;

        int[] chsB = new int[26];
        for (int i = 0; i < b.length(); i++) {
            chsB[b.charAt(i) - 'a']++;
        }

        int[] chsA = new int[26];
        for (int i = 0; i < a.length(); i++) {
            chsA[a.charAt(i) - 'a']++;
        }

        //将a,b换为a中最多的字母
        int maxA = 0;
        for (int i = 1; i < chsA.length; i++) {
            if (chsA[maxA] < chsA[i]) {
                maxA = i;
            }
        }
        res = Math.min(res, a.length() - chsA[maxA] + b.length() - chsB[maxA]);

        //将a,b换为b中最多的字母
        int maxB = 0;
        for (int i = 1; i < chsB.length; i++) {
            if (chsA[maxB] < chsB[i]) {
                maxB = i;
            }
        }
        res = Math.min(res, a.length() - chsA[maxB] + b.length() - chsB[maxB]);

        //条件1和条件2
        res = Math.min(res, count(chsA, chsB));
        res = Math.min(res, count(chsB, chsA));
        return res;
    }

    public static int count(int[] chsA, int[] chsB) {
        //枚举字母c，让a中字母全部小于c,b中全部大于等于c

        //preSumA[i]表示chsA[i..25]之和
        int[] preSumA = new int[26];
        preSumA[25] = chsA[25];
        for (int i = 24; i >= 0; i--) {
            preSumA[i] = chsA[i] + preSumA[i + 1];
        }

        //preSumB[i]
        int preSumB = chsB[0];
        int res = Integer.MAX_VALUE;
        //c的取值范围为[b..z]
        for (int i = 1; i <= 25; i++) {
            int count = preSumB + preSumA[i];
            preSumB += chsB[i];
            res = Math.min(count, res);
        }

        return res;
    }

    public static void main(String[] args) {
        String a = "ace";
        String b = "abe";
        System.out.println(minCharacters(a, b));
    }
}
