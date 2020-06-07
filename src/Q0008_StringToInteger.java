public class Q0008_StringToInteger {
    public int myAtoi(String str) {
       int res = 0;
       if (str == null || str.length() == 0) {
           return res;
       }
       int i = 0;
       // 数字的符号，默认为正
       int signBit = 1;
       while (i < str.length() && str.charAt(i) == ' ') {
           i++;
       }
       if (i < str.length() &&
               (str.charAt(i) == '-' || str.charAt(i) == '+')) {
           signBit = str.charAt(i) == '-' ? -1 : 1;
           i++;
       }
       while (i < str.length() && str.charAt(i) >= '0'
               && str.charAt(i) <= '9') {
           int cur = str.charAt(i) - '0';

           if (signBit == 1) {
               // 判断是否已经越界
               if (res > Integer.MAX_VALUE/10 ||
                       Integer.MAX_VALUE - cur <= 10 * res) {
                   return Integer.MAX_VALUE;
               }
               res = 10 * res + cur;
           } else {
               // 判断是否已经越界
               if (res < Integer.MIN_VALUE/10 ||
                       Integer.MIN_VALUE + cur >= 10 * res) {
                   return Integer.MIN_VALUE;
               }
               res = 10 * res - cur;
           }
           i++;
       }

       return res;
    }
}
