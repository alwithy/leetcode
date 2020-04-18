import java.util.Arrays;

public class Q0611_ValidTriangleNumber {
    public int triangleNumber1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int count = 0;
        int sum,l,r,mid;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum = nums[i] + nums[j];
                //二分查找
                l = j + 1;
                r = nums.length - 1;
                while (r >= l) {
                    mid = l + ((r - l) >> 1);
                    if (nums[mid] >= sum) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                count += l - j - 1;
            }
        }
        return count;
    }

    public int triangleNumber2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        int k;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            k = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int l = 3;
        int r = 4;
        int mid = (l + r) / 2;
        System.out.println(mid);
    }
}
