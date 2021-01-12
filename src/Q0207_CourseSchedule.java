import java.util.ArrayList;
import java.util.List;

public class Q0207_CourseSchedule {
    //edges[i][j] 表示j为i的前置任务
    List<List<Integer>> edges;
    //visit[i] = 0表示未访问, 1表示访问中, 2表示已访问
    int[] visit;
    //valid为true表示尚未发现环
    boolean valid;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visit = new int[numCourses];
        valid = true;
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        //统计每一个任务的前置任务
        for (int[] cur : prerequisites) {
            //cur[1]为cur[0]的前置
            edges.get(cur[0]).add(cur[1]);
        }

        //每次选取一个未访问的节点进行DFS
        for (int i = 0; i < numCourses && valid; i++) {
            if (visit[i] == 0) {
                dfs(i);
            }
        }

        return valid;
    }

    private void dfs(int u) {
        //将点标记为访问中
        visit[u] = 1;

        //找到u的所有前置中尚未完成的，并尝试完成
        for (int v : edges.get(u)) {
            if (visit[v] == 2) {
                continue;
            }

            if (visit[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else { //visit[v] == 1，发现环
                valid = false;
                return;
            }
        }

        //任务u标记为已访问
        visit[u] = 2;
    }
}
