import java.util.Arrays;
import java.util.Comparator;

public class Q406_QueueReconstructionByHeight {
    public static int[][] reconstructQueue(int[][] people) {
        //按h升序,k降序排列
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        });
        int[][] res = new int[people.length][];
        for (int[] person : people) {
            int space = person[1] + 1;
            for (int i = 0; i < res.length; i++) {
                if (res[i] == null) {
                    space--;
                    if (space == 0) {
                        res[i] = person;
                        break;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = reconstructQueue(people);
    }
}
