public class Q0848_ShiftingLetters {
    public String shiftingLetters(String S, int[] shifts) {
        int shift = 0;
        char[] s = S.toCharArray();
        for (int i = S.length() - 1; i >= 0; i--) {
            shift = shift + (shifts[i] % 26);
            s[i] = (char) ((S.charAt(i) - 'a' + shift) % 26 + 'a');
        }
        return String.valueOf(s);
    }
}
