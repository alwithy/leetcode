public class Q1016_BinaryStringWithSubstringsRepresenting1ToN {
    public boolean queryString(String S, int N) {
        boolean flag = true;
        for(int i = Math.max(1,N/2); i < N + 1; i ++) {
            String s = Integer.toBinaryString(i);
            if(!S.contains(s)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

}
