import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_240619_14284 {
    static class Edge {
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int n;
    static int m;
    static int[] dist;
    static final int INF = 987654321;
    static ArrayList<Integer>[] query;
    static ArrayList<Edge>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        query = new ArrayList[m];
        adjList = new ArrayList[n + 1];

        for (int i = 0; i < m; i++) {
            query[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            query[i].add(u);
            query[i].add(v);
            query[i].add(w);
        }

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            int u = query[i].get(0);
            int v = query[i].get(1);
            int w = query[i].get(2);

            adjList[u].add(new Edge(v, w));
            adjList[v].add(new Edge(u, w));

        }

        int answer = dijkstra(s, t);
        sb.append(answer).append("\n");
        System.out.println(answer);

    }

    static int dijkstra(int start, int end) {
        dist = new int[n + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.weight, o2.weight);
        });

        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge nowEdge = pq.poll();
            int nowNode = nowEdge.node;

            for (int i = 0; i < adjList[nowNode].size(); i++) {
                int nextNode = adjList[nowNode].get(i).node;
                int nextWeight = adjList[nowNode].get(i).weight;

                if (dist[nextNode] > dist[nowNode] + nextWeight) {
                    dist[nextNode] = dist[nowNode] + nextWeight;
                    pq.add(new Edge(nextNode, dist[nextNode]));
                }
            }
        }

        return dist[end];
    }
}
