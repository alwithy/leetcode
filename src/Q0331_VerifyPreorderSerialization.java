public class Q0331_VerifyPreorderSerialization {
    public boolean isValidSerialization(String preorder) {
        //官方题解方法一
        String[] strs = preorder.split(",");
        int slot = 1;
        for (String s : strs) {
            slot--;
            if (slot < 0) {
                break;
            }
            if (!s.equals("#")) {
                slot += 2;
            }
        }

        return slot == 0;
    }
}
