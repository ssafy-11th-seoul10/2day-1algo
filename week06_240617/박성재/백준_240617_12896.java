import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_240617_12896 {
    static int n;
    static ArrayList<Integer>[] adjList;
    static int maxDistance;
    static int maxDistanceNode;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(1, 0);

        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(maxDistanceNode, 0);

        sb.append((maxDistance + 1) / 2).append("\n");
        System.out.println(sb);

    }

    static void dfs(int now, int depth) {
        if (visited[now]) {
            return;
        }

        if (depth > maxDistance) {
            maxDistance = depth;
            maxDistanceNode = now;
        }

        visited[now] = true;

        for (int i = 0; i < adjList[now].size(); i++) {
            int next = adjList[now].get(i);

            dfs(next, depth + 1);
        }
    }

}
