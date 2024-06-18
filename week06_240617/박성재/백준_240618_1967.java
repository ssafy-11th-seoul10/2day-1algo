import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_240618_1967 {
    static class Edge {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int n;
    static ArrayList<Edge>[] adjList;
    static boolean[] visited;
    static int maxDistanceNode;
    static int maxDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            sb.append(0).append("\n");
            System.out.println(sb);
            return;
        }

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Edge(v, w));
            adjList[v].add(new Edge(u, w));
        }

        visited = new boolean[n + 1];
        maxDistance = 0;

        dfs(1, 0);

        visited = new boolean[n + 1];
        maxDistance = 0;
        dfs(maxDistanceNode, 0);

        sb.append(maxDistance).append("\n");
        System.out.println(sb);

    }

    static void dfs(int now, int depth) {
        if (visited[now])
            return;
        visited[now] = true;

        if (maxDistance < depth) {
            maxDistance = depth;
            maxDistanceNode = now;
        }

        for (int i = 0; i < adjList[now].size(); i++) {
            Edge edge = adjList[now].get(i);

            int node = edge.node;
            int weight = edge.weight;

            dfs(node, depth + weight);
        }
    }

}
