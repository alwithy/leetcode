import java.util.PriorityQueue;

public class Q0775_GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        //局部倒置一定是全局倒置，但全局倒置不一定是局部倒置
        //若存在一种全局倒置，满足A[i] < A[i + n], 且n >= 2，则return false
        //minValue[i]代表从A[i]到A[A.length - 1]中的最小元素
        int[] minValue = new int[A.length];
        minValue[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            minValue[i] = Math.min(minValue[i + 1], A[i]);
        }
        for (int i = 0; i < A.length; i++) {
            if (i + 2 < A.length && A[i] > minValue[i + 2]) {
                return false;
            }
        }
        return true;
    }
}
