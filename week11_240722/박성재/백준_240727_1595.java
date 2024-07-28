import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_240727_1595 {
    static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static List<Edge>[] edgeList;
    static Set<Integer> set;
    static final int N = 10_000;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String s;

        edgeList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }

        while ((s = br.readLine()) != null && !s.isEmpty()) {
            st = new StringTokenizer(s);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edgeList[u].add(new Edge(v, w));
            edgeList[v].add(new Edge(u, w));

            set.add(u);
            set.add(v);

        }
        answer = 0;
        for (int num : set) {
            visited = new boolean[N + 1];
            dfs(num, 0);
        }

        sb.append(answer).append("\n");
        System.out.println(sb);
    }

    static void dfs(int now, int sum) {
        if (visited[now])
            return;

        visited[now] = true;
        answer = Math.max(answer, sum);
        for (int i = 0; i < edgeList[now].size(); i++) {
            Edge next = edgeList[now].get(i);

            if (!visited[next.to]) {
                dfs(next.to, sum + next.weight);
            }
        }

    }
}
