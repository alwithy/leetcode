import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q0556_NextGreaterElement {
    public static int nextGreaterElement(int n) {
        Integer[] num = new Integer[32];
        int max = 2147483647; //
        int length = 0;
        while (n > 0) {
            num[length++] = n % 10;
            n /= 10;
        }
        // 从最低位开始依次向上找有无逆序对
        // 逆序对指的是num[i] > num[j], 且i < j
        // 找出在i之后最小的比num[i]大的数字，并交换
        boolean hasGreater = false;
        int i = 0;
        for (; i < length - 1; i++) {
            if (num[i] > num[i + 1]) {
                hasGreater = true;
                break;
            }
        }
        // 需要交换的是i + 1
        if (!hasGreater) return -1;
        int min = i;
        for (int j = i; j >= 0; j--) {
            if (num[j] > num[i + 1] && num[j] < num[min]) {
                min = j;
            }
        }
        swap(num, i + 1, min);

        Arrays.sort(num, 0,
                i + 1, (k, l) -> ((Integer)l).compareTo((Integer)k));
        int res = 0;
        for (int j = length - 1; j >= 0; j--) {
            if (res > max/10 || max - res * 10 < num[j]) {
                return -1;
            }
            res = res * 10 + num[j];
        }

        return res;
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(1999999999));
    }
}


