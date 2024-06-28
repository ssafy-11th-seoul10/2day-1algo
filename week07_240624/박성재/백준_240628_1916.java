import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_240628_1916 {
    static class Edge {
        int node;
        int weight;

        public Edge(int next, int weight) {
            this.node = next;
            this.weight = weight;
        }
    }

    static int n;
    static ArrayList<Edge>[] graph;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        sb.append(dijkstra(start, end)).append("\n");
        System.out.println(sb);
    }

    static int dijkstra(int start, int end) {
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        });
        dist[start] = 0;

        pq.add(new Edge(start, 0));
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            int nowNode = now.node;
            if (visited[nowNode])
                continue;
            visited[nowNode] = true;
            for (int i = 0; i < graph[nowNode].size(); i++) {
                Edge next = graph[nowNode].get(i);

                int nextNode = next.node;
                if (dist[nextNode] > dist[nowNode] + next.weight) {
                    dist[nextNode] = dist[nowNode] + next.weight;
                    pq.add(new Edge(nextNode, dist[nextNode]));
                }
            }
        }
        return dist[end];
    }
}
