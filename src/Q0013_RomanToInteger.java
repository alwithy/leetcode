public class Q0013_RomanToInteger {
    public int romanToInt(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == 'M') {
                res += 1000;
            } else if (c == 'D') {
                res += 500;
            } else if (c == 'C') {
                if (index + 1 < s.length()) {
                    char next = s.charAt(index + 1);
                    if (next == 'M') {
                        res += 900;
                        index++;
                    } else if (next == 'D') {
                        res += 400;
                        index++;
                    } else {
                        res += 100;
                    }
                } else {
                    res += 100;
                }
            } else if (c == 'L') {
                res += 50;
            } else if (c == 'X') {
                if (index + 1 < s.length()) {
                    char next = s.charAt(index + 1);
                    if (next == 'L') {
                        res += 40;
                        index++;
                    } else if (next == 'C') {
                        res += 90;
                        index++;
                    } else {
                        res += 10;
                    }
                } else {
                    res += 10;
                }
            } else if (c == 'V') {
                res += 5;
            } else if (c == 'I') {
                if (index + 1 < s.length()) {
                    char next = s.charAt(index + 1);
                    if (next == 'X') {
                        res += 9;
                        index++;
                    } else if (next == 'V') {
                        res += 4;
                        index++;
                    } else {
                        res += 1;
                    }
                } else {
                    res += 1;
                }
            }
            index++;
        }

        return res;
    }

}
