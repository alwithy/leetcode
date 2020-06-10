package vivo_2020;

public class Q3 {
    public int solution (int n) {
        int res = 0;
        if (n <= 0) return res;
        int day = 0;
        while (n > 0) {
            day++;
            if (n - day > 0) {
                n -= day;
                res += day * day;
            } else {
                res += day * n;
                break;
            }
        }

        return res;
    }
}
