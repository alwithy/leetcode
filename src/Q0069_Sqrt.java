public class Q0069_Sqrt {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        // 二分查找
        int l = 1;
        int r = x;
        while (l < x) {
            int mid = l + ((r - l) >> 1);
            if (mid > x/mid) {
                r = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1)) {
                    l = mid;
                    break;
                }
                l = mid + 1;
            }
        }

        return l;
    }
}
