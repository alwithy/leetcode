public class Q0795_NumberOfSubarraysWithBoundedMaximum {
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L - 1);
    }

    //count(A,bound)返回A数组子数组中满足所有元素小于等于bound的数组数量
    public static int count(int[] A, int bound) {
        int res = 0;
        int current = 0;
        for (int i : A) {
            current = i <= bound ? current + 1 : 0;
            res += current;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,3};
        System.out.println(
                numSubarrayBoundedMax(arr,2,3)
        );
    }
}
