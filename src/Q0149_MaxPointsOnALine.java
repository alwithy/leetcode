import java.util.HashMap;

public class Q0149_MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points == null || points.length < 2) {
            return points == null ? 0 : points.length;
        }
        int res = 0;
        int n = points.length;
        //key为直线,value为直线上的点的数量
        HashMap<String, Integer> map = new HashMap<>();
        //对于每一个点i，考虑它和之后的点组成的直线最多经过多少点
        //由于必定过点i，所以保存直线斜率即可
        for (int i = 0; i < n; i++) {
            map.clear();
            int curMax = 0;
            int duplicates = 1;//和i点重叠的点
            for (int j = i + 1; j < n; j++) {
                String line = getLine(points[i][0], points[i][1],
                        points[j][0], points[j][1]);
                if (line == null) {
                    duplicates++;
                    continue;
                }
                int value = map.containsKey(line) ? map.get(line) + 1 : 1;
                map.put(line, value);
                curMax = Math.max(curMax, value);
            }
            res = Math.max(curMax + duplicates, res);
        }

        return res;
    }

    //y = a * x + b
    //m = y2 - y1
    //n = x2 - x1
    //g = gcd(m,n)
    //返回字符串 m/g + "_"+ n/g
    //水平线返回"y=" + b
    //垂线返回"x=" + x1
    //点返回null
    private String getLine(int x1, int y1,
                          int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return null;
        }

        if (x1 == x2) {
            return "x=" + x1;
        }

        if (y1 == y2) {
            return "y=" + y1;
        }

        int m = y2 - y1;
        int n = x2 - x1;
        int g = gcd(n, m);

        return m/g + "_" + n/g;
    }

    public int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
