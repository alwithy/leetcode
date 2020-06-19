public class Q0468_ValidateIPAddress {
    static String[] ip;
    static String[] res = {"IPv4", "IPv6", "Neither"};

    public static String validIPAddress(String IP) {
        if (IP == null || IP.length() < 7) return res[2];
        boolean isIPv4 = true;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') {
                ip = IP.split("\\.", 4);
                if (ip.length != 4) return res[2];
                break;
            }
            if (IP.charAt(i) == ':') {
                isIPv4 = false;
                ip = IP.split(":", 8);
                if (ip.length != 8) return res[2];
                break;
            }
        }

        for (String num : ip) {
            if (!isValidNum(isIPv4, num)) return res[2];
        }

        return isIPv4 ? res[0] : res[1];
    }

    private static boolean isValidNum(boolean isIPv4, String num) {
        if (num == null || num.isEmpty()) return false;
        if (isIPv4) {
            if ((num.length() > 1 && num.charAt(0) == '0')
                    || num.length() > 3) {
                return  false;
            }
            int res = 0;
            int cur;
            for (int i = 0; i < num.length(); i++) {
                cur = num.charAt(i) - '0';
                if (cur < 0 || cur > 9) return false;
                res = res * 10 + cur;
            }
            return res >= 0 && res <= 255;
        } else {
            if (num.length() > 4) {
                return false;
            }
            char cur;
            for (int i = 0; i < num.length(); i++) {
                cur = num.charAt(i);
                if (!((cur >= '0' && cur <= '9')
                        || (cur >= 'a' && cur <= 'f')
                        || (cur >= 'A' && cur <= 'F'))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        String s = "12..33.4";
        System.out.println(validIPAddress(s));
    }
}
