public class Q0334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        //方法一，左侧小根堆，右侧大根堆，略
        //方法二，设三元组前两个数字为x,y，当前遇到的数字为z
        //1.z > y : 返回true
        //2.x < z <= y : 更新y, y = z
        //3. x < z : 更新x, x = z
        //在3中, x和y保留了两个三元组的信息,第一个三元组前两位是 old x, old y
        //第二个三元组首位是z
        int x = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        for (int z : nums) {
            if (z > y) {
                return true;
            } else if (z > x) {
                y = z;
            } else {
                x = z;
            }
        }

        return false;
    }
}
