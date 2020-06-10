public class Q0043_MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        StringBuilder res = new StringBuilder();
        StringBuilder cur;
        int curDigit, carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int multiNum = num2.charAt(i) - '0';
            cur = new StringBuilder(num1);
            for (int j = num1.length() - 1; j >= 0 ; j--) {
                curDigit = multiNum * (cur.charAt(j) - '0') + carry;
                carry = 0;
                if (curDigit >= 10) {
                    carry = curDigit/10;
                    curDigit %= 10;
                }
                cur.replace(j, j + 1, String.valueOf(curDigit));
            }
            if (carry > 0) {
                cur = new StringBuilder(String.valueOf(carry)).append(cur);
                carry = 0;
            }

            if (cur.charAt(0) == '0') continue;

            for (int j = num2.length() - 2; j >= i; j--) {
                cur.append(0);
            }

            res = add(res, cur);
        }

        return res.toString();
    }

    private static StringBuilder add(StringBuilder num1, StringBuilder num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;


        if (num1.length() < num2.length()) {
            StringBuilder temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int addition, carry = 0;
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (j >= 0) {
            addition = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            carry = 0;
            if (addition >= 10) {
                carry = 1;
                addition -= 10;
            }
            res = new StringBuilder(String.valueOf(addition)).append(res);
            i--;
            j--;
        }

        while (i >= 0) {
            addition = num1.charAt(i) - '0' + carry;
            carry = 0;
            if (addition >= 10) {
                carry = 1;
                addition -= 10;
            }

            res = new StringBuilder(String.valueOf(addition)).append(res);
            i--;
        }

        if (carry > 0) {
            res = new StringBuilder(String.valueOf(carry)).append(res);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(multiply("999", "999"));
        StringBuilder a = new StringBuilder("456");
        StringBuilder b = new StringBuilder("456");
        //System.out.println(add(a, b).toString());
    }
}
