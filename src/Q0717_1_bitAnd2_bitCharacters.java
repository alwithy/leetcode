public class Q0717_1_bitAnd2_bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {//bits[i] == 0
                i++;
            }
        }
        return i == bits.length - 1;
    }
}
