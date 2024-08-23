import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_240823_1939 {

    static class AdjNode {
        int to;
        int weight;

        AdjNode(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<AdjNode>[] adj = new ArrayList[n + 1];

        for (int u = 1; u <= n; u++) {
            adj[u] = new ArrayList<AdjNode>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new AdjNode(b, c));
            adj[b].add(new AdjNode(a, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int low = 1; // 항상 true
        int high = 1000000001; // 항상 false

        while (low + 1 < high) { // T-F 배열
            int mid = (low + high) / 2;
            boolean[] visited = new boolean[n + 1];
            ArrayDeque<Integer> bfsQue = new ArrayDeque<Integer>();
            bfsQue.offer(s);
            visited[s] = true;

            while (!bfsQue.isEmpty()) {
                int cur = bfsQue.poll();

                for (AdjNode nxt : adj[cur]) {
                    if (visited[nxt.to] || mid > nxt.weight) continue;

                    visited[nxt.to] = true;
                    bfsQue.offer(nxt.to);
                }
            }

            if (visited[e]) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
        br.close();
    }

}
