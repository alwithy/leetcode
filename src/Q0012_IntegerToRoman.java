public class Q0012_IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder[] res = new StringBuilder[7];
        // 分段处理,分为7段，从高到低分别对应M,D,C,L,X,V,I
        //                               0 1 2 3 4 5 6
        // 特殊情况，比如IV，就放在res[5]
        for (int i = 0; i < res.length; i++) {
            res[i] = new StringBuilder();
        }
        if (num >= 1000) {
            for (int i = 0; i < num/1000; i++) {
                res[0].append("M");
            }
            num %= 1000;
        }
        if (num >= 900) {
            res[0].append("CM");
            num -= 900;
        }
        if (num >= 500) {
            res[1].append("D");
            num -= 500;
        }
        if (num >= 400) {
            res[1].append("CD");
            num -= 400;
        }
        if (num >= 100) {
            for (int i = 0; i < num/100; i++) {
                res[2].append("C");
            }
            num %= 100;
        }
        if (num >= 90) {
            res[2].append("XC");
            num -= 90;
        }
        if (num >= 50) {
            res[3].append("L");
            num -= 50;
        }
        if (num >= 40) {
            res[3].append("XL");
            num -= 40;
        }
        if (num >= 10) {
            for (int i = 0; i < num / 10; i++) {
                res[4].append("X");
            }
            num %= 10;
        }
        if (num >= 9) {
            res[4].append("IX");
            num -= 9;
        }
        if (num >= 5) {
            res[5].append("V");
            num -= 5;
        }
        if (num >= 4) {
            res[5].append("IV");
            num -= 4;
        }
        if (num >= 1) {
            for (int i = 0; i < num; i++) {
                res[6].append("I");
            }
        }

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            roman.append(res[i]);
        }

        return roman.toString();
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRomanBest(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num >= 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

}
