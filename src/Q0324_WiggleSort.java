import java.util.Arrays;

public class Q0324_WiggleSort {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int index = arr.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = arr[index--];
        }

        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = arr[index--];
        }
    }
}
