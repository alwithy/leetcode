public class Q0831_MaskingPersonalInformation {
    public String maskPII(String S) {
        StringBuilder res = new StringBuilder();
        if (S.length() >= 8 &&
                S.matches("[a-zA-Z]{2,}?@[a-zA-Z]++\\.[a-zA-Z]++")) {
            String[] strs = S.split("@");

            res.append(strs[0].substring(0,1).toLowerCase());
            res.append("*****");
            res.append(strs[0].substring
                    (strs[0].length() - 1).toLowerCase());

            res.append("@").append(strs[1].toLowerCase());
        } else {
            // 电话号码
            // 从末尾开始找到4个数字；
            int num = 0;
            for (int i = S.length() - 1; i >= 0; i--) {
                char c = S.charAt(i);
                if (num < 4) {
                    if (c >= '0' && c <= '9') {
                        res.insert(0, c);
                        num++;
                    }
                } else {
                    if (c >= '0' && c <= '9') num++;
                }
            }

            StringBuilder sb = new StringBuilder();
            if (num > 10) {
                sb.append("+");
                while (num > 10) {
                    sb.append("*");
                    num--;
                }
                sb.append("-");
            }
            sb.append("***-***-").append(res);
            res = sb;
        }

        return res.toString();
    }
}
