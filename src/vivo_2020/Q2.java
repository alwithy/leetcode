package vivo_2020;

import java.util.Arrays;

public class Q2 {
    public int solution (int n) {
        if (n <= 9) return n;
        int numOfDigits = 0;
        int[] res = new int[10];
        int ans = 0;

        while (n > 9) {
            for (int i = 9; i >= 2; i--) {
                if (n % i == 0) {
                    res[numOfDigits++] = i;
                    n /= i;
                    break;
                } else if (i == 2) {
                    return -1;
                }
            }
        }
        if (n > 1) {
            res[numOfDigits] = n;
        }

        Arrays.sort(res);
        for (int i = 0; i < 10; i++) {
            ans = ans * 10 + res[i];
        }

        return ans;
    }
}
