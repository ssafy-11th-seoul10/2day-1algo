import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_240820_16398 {

    static class AdjNode implements Comparable<AdjNode> {
        int to, weight;

        AdjNode(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(AdjNode o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] adj = new int[n][n];

        for (int u1 = 0; u1 < n; u1++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int u2 = 0; u2 < n; u2++) {
                adj[u1][u2] = Integer.parseInt(st.nextToken());
            }
        }

        int nodeCount = 0;
        long weightSum = 0;
        int[] minWeight = new int[n];
        boolean[] connected = new boolean[n];
        PriorityQueue<AdjNode> pq = new PriorityQueue<AdjNode>();

        for (int u = 0; u < n; u++) {
            minWeight[u] = Integer.MAX_VALUE;
        }

        pq.offer(new AdjNode(0, 0));
        minWeight[0] = 0;

        while (!pq.isEmpty()) {
            AdjNode adjNode = pq.poll();
            int curNode = adjNode.to;

            if (connected[curNode]) continue;

            connected[curNode] = true;
            weightSum += adjNode.weight;

            if (++nodeCount == n) break;

            for (int nxtNode = 0; nxtNode < n; nxtNode++) {
                if (!connected[nxtNode] && adj[curNode][nxtNode] < minWeight[nxtNode]) {
                    pq.offer(new AdjNode(nxtNode, adj[curNode][nxtNode]));
                    minWeight[nxtNode] = adj[curNode][nxtNode];
                }
            }
        }

        System.out.println(weightSum);
        br.close();
    }

}
