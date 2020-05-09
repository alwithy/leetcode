import java.util.ArrayList;
import java.util.List;

public class Q0120_Triangle {
    //递归版，数据量特别大的时候会超时
    public static int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0
                || triangle.get(0) == null
                || triangle.get(0).size() == 0) {
            return 0;
        }
        //从最后一层往上走
        int res = Integer.MAX_VALUE;
        int[] costs = new int[triangle.size()];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = triangle.get(triangle.size() - 1).get(i)
                    + getCost(triangle, triangle.size() - 1, i);
            res = Math.min(res, costs[i]);
        }

        return res;
    }

    private static int getCost(List<List<Integer>> triangle,
                        int row, int col) {
        if (row == 0) {
            return triangle.get(0).get(0);
        }

        if (col > 0 && col < row) {
            return Math.min(
                    triangle.get(row - 1).get(col)
                            + getCost(triangle, row - 1, col),
                    triangle.get(row - 1).get(col - 1)
                            + getCost(triangle, row - 1, col - 1));
        } else if (col == 0) {
            return triangle.get(row - 1).get(0)
                    + getCost(triangle, row - 1, 0);
        } else {// row == col
            return triangle.get(row - 1).get(row - 1)
                    + getCost(triangle, row - 1, row - 1);
        }
    }

    //动态规划版
    public static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0
                || triangle.get(0) == null
                || triangle.get(0).size() == 0) {
            return 0;
        }

        int res = Integer.MAX_VALUE;
        //costs保存当前行的消费，pre保存上一行的
        int[] costs = new int[triangle.size()];
        int[] pre = new int[triangle.size()];
        int[] temp;
        pre[0] = triangle.get(0).get(0);
        //从上往下递推,i代表层数，j代表列数
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j <= i; j++) {
                //处理左边界
                if (j == 0) {
                    costs[j] = pre[0] + triangle.get(i).get(j);
                } else if (j == i) {
                    //处理右边界
                    costs[j] = pre[j - 1] + triangle.get(i).get(j);
                } else {
                    //0 < j < i，通常情况
                    costs[j] = Math.min(pre[j], pre[j - 1]) + triangle.get(i).get(j);
                }
            }

            //交换costs和pre
            temp = costs;
            costs = pre;
            pre = temp;
        }

        for (int cost : pre) {
            res = Math.min(cost, res);
        }

        return res;
    }

}
