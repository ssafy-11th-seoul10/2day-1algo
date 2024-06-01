import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1240_240530 {

    static class Edge {
        int to, dist;

        Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] adj = new ArrayList[n + 1];

        for (int u = 1; u <= n; u++) {
            adj[u] = new ArrayList<Edge>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[from].add(new Edge(to, dist));
            adj[to].add(new Edge(from, dist));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            ArrayDeque<Edge> bfsQue = new ArrayDeque<Edge>();
            boolean[] visited = new boolean[n + 1];
            bfsQue.offer(new Edge(from, 0));
            visited[from] = true;

            whileBfs: while (!bfsQue.isEmpty()) {
                Edge curEdge = bfsQue.poll();
                int curIdx = curEdge.to;
                int curDist = curEdge.dist;

                for (Edge nxtEdge : adj[curIdx]) {
                    if (visited[nxtEdge.to]) {
                        continue;
                    }

                    visited[nxtEdge.to] = true;
                    int nxtDist = curDist + nxtEdge.dist;

                    if (nxtEdge.to == to) {
                        sb.append(nxtDist).append("\n");
                        break whileBfs;
                    }

                    bfsQue.offer(new Edge(nxtEdge.to, nxtDist));
                }
            }
        }

        System.out.print(sb);
        br.close();
    }

}
