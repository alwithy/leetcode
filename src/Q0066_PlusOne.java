public class Q0066_PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return null;
        int bring = 1;
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i] += bring;
            bring = 0;
            if (digits[i] < 10) {
                return digits;
            } else {
                digits[i] = 0;
                bring = 1;
            }
        }

        if (bring == 1) {
            int[] res = new int[len + 1];
            res[0] = 1;
            for (int i = 1; i < len + 1; i++) {
                res[i] = digits[i - 1];
            }
            return res;
        } else {
            return digits;
        }
    }
}
