public class Q0074_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1
        || matrix[0] == null || matrix[0].length < 1
        || target < matrix[0][0]
        || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        //使用两次二分查找，第一次确定target可能在的行数
        //第二次在可能在的行二分查找target
        int left = 0;
        int right = matrix.length - 1;
        int mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (left == mid) {
                if (matrix[right][0] == target) {
                    return true;
                } else {
                    left = matrix[right][0] > target ? left : right;
                    break;
                }
            }
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid;
            } else {//matrix[mid][0] > target
                right = mid - 1;
            }
        }
        int row = left;
        left = 0;
        right = matrix[0].length - 1;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {//matrix[row][mid] > target
                right = mid - 1;
            }
        }

        return matrix[row][left] == target;
    }
}
