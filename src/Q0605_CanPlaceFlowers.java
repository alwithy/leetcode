public class Q0605_CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length < n) {
            return false;
        }
        if (flowerbed.length == 1 && n == 1) {
            return flowerbed[0] != 1;
        }
        //count记录可以种花的位置的数量
        int count = 0;
        if (flowerbed.length >= 2
                &&flowerbed[0] == 0
                && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            count++;
        }
        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] == 0
                    && flowerbed[i] == 0
                    && flowerbed[i+1] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        if (flowerbed.length >= 2
                &&flowerbed[flowerbed.length - 2] == 0
                && flowerbed[flowerbed.length - 1] == 0) {
            count++;
        }
        return count >= n;
    }
}
