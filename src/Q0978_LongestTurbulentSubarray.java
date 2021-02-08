public class Q0978_LongestTurbulentSubarray {
    public static int maxTurbulenceSize(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr == null ? 0 : arr.length;
        }
        //奇数项大和偶数项大各做一次，取长度最大值
        return Math.max(getLen(arr, true), getLen(arr, false));
    }

    public static int getLen(int[] arr, boolean oddBigger) {
        int n = arr.length;
        int res = 1;
        //窗口范围为arr[l..r]
        int l = 0;
        for (int r = 1; r < n; r++) {
            //r是新增项，考虑r - 1与r是否符合要求
            if (l == r) {
                continue;
            }

            boolean valid = true;
            if (oddBigger) {
                //奇数项大
                if ((r - 1) % 2 == 1 && arr[r - 1] <= arr[r]) {
                    valid = false;
                } else if ((r - 1) % 2 == 0 && arr[r - 1] >= arr[r]) {
                    valid = false;
                }
            } else {
                //偶数项大
                if ((r - 1) % 2 == 1 && arr[r - 1] >= arr[r]) {
                    valid = false;
                } else if ((r - 1) % 2 == 0 && arr[r - 1] <= arr[r]) {
                    valid = false;
                }
            }

            if (!valid) {
                l = r;
                continue;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {9,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSize(arr));
    }
}
