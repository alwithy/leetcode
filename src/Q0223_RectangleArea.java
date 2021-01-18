public class Q0223_RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long s1 = (C - A) * (D - B);
        long s2 = (G - E) * (H - F);
        //重叠部分面积
        long s3 = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        if (G <= A || E >= C || H <= B || F >= D) {
            s3 = 0;
        }

        return (int) (s1 + s2 - s3);
    }
}
