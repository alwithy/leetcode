public class Q0275_HIndex {
    public static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        //二分法
        int n = citations.length;
        int l = 0, r = n - 1, mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (citations[mid] >= n - mid) {
                if (mid - 1 >= 0 && citations[mid - 1] < n - mid + 1) {
                    l = mid;
                    break;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return citations[l] >= n - l ? n - l : 0;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,4,4};
        System.out.println(hIndex(arr));
    }
}
