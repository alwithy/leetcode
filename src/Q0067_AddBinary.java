public class Q0067_AddBinary {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int len1 = a.length();
        int len2 = b.length();
        int[] arr = new int[len1];
        int i = len1 - 1;
        int bring = 0;
        while (len1 - i <= len2) {
            arr[i] = a.charAt(i) - '0' + b.charAt(len2 - len1 + i) - '0' + bring;
            bring = 0;
            if (arr[i] > 1) {
                arr[i] -= 2;
                bring = 1;
            }
            i--;
        }

        while (i >= 0) {
            arr[i] = a.charAt(i) - '0' + bring;
            bring = 0;
            if (arr[i] > 1) {
                arr[i] -= 2;
                bring = 1;
            }
            i--;
        }
        StringBuilder res = new StringBuilder();
        if (bring == 1) res.append(1);
        for (int num : arr) {
            res.append(num);
        }

        return res.toString();
    }
}
