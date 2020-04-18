public class Q0667_BeautifulArrange {
    public static int[] constructArray(int n, int k) {
        int[] res = new int[n];
        //官方题解2，构造
        if (k == 1) {
            for (int i = 0; i < res.length; i++) {
                res[i] = i + 1;
            }
        } else {
            //数组前半部分以差值为1递增，后半部分为产生最大差值的排列
            //产生k个差值需要的数组长度为k + 1
            // 此处用k变量记录第二部分数组长度
            k++;
            boolean change = true;
            int current = 1;
            if (k == res.length) {
                //如果整个数组都是[1, n, 2, n-1, 3, n-2, ....]
                for (int i = 0; i < res.length; i++) {
                    if (change) {
                        res[i] = current;
                        current++;
                    } else {
                        res[i] = n + 1 - res[i - 1];
                    }
                    change = !change;
                }
            } else {
                int i = 0;
                for (; i < res.length - k; i++) {
                    res[i] = i + 1;
                }
                //构建第二部分数组
                //第二部分数组的形式类似[1, n, 2, n-1, 3, n-2, ....]
                //不过要在所有元素上加i
                for (int j = i; j < res.length; j++) {
                    if (change) {
                        res[j] = i + current;
                        current++;
                    } else {
                        res[j] = 2 * i + k + 1 - res[j - 1];
                    }
                    change = !change;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = constructArray(5,2);
    }
}
