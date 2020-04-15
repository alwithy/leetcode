public class Q0283_MoveZeroes {
    public static void moveZeroes1(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("Invalid input!");
        }
        int ahead = 0;
        int behind = 0;
        while (behind < nums.length && ahead < nums.length) {
            if (nums[ahead] == 0) {
                behind = findNextNonzero(nums, ahead);
                if (behind >= nums.length) {
                    return;
                }
                swap(nums, ahead, behind);
            }
            ahead++;
        }
    }

    public static int findNextNonzero(int[] nums, int index) {
        while (index < nums.length && nums[index] == 0) {
            index++;
        }
        return index;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //最优
    public static void moveZeros2(int[] nums) {
        if (nums == null || nums.length <= 0) {
            throw new RuntimeException("Invalid input!");
        }

        //behind为慢指针，ahead为快指针
        int behind = 0;
        for (int ahead = 0; ahead < nums.length; ahead++) {
            if (nums[ahead] != 0) {
                nums[behind++] = nums[ahead];
            }
        }

        for (;behind < nums.length; behind++) {
            nums[behind] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 0, 0, 6};
        moveZeroes1(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(" " + nums[i]);
        }
    }
}
