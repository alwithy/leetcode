public class Q0900_RLEIterator {
    static class RLEIterator {
        // restIndex记录iterator走到哪一个偶数位了
        private int restIndex;
        // restQuantity记录该数字剩下的数量
        private int restQuantity;
        private int[] arr;

        public RLEIterator(int[] A) {
            this.arr = A;
            this.restIndex = 0;
            this.restQuantity = A[0];
        }

        public int next(int n) {
            int res = -1;
            while (n > 0) {
                if (restQuantity == 0 && restIndex == arr.length - 2) {
                    res = -1;
                    break;
                }

                if (restQuantity == 0) {
                    restIndex += 2;
                    restQuantity = arr[restIndex];
                    continue;
                }

                if (n > restQuantity) {
                    n -= restQuantity;
                    restQuantity = 0;
                } else {
                    restQuantity -= n;
                    res = arr[restIndex + 1];
                    break;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int[] arr = {923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82};
        RLEIterator rleIterator = new RLEIterator(arr);
        int res1 = rleIterator.next(612783106);
        int res2 = rleIterator.next(486444202);
    }
}
