import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_240826_1368 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parents;

    static void initParents(int n) {
        parents = new int[n + 1];

        for (int u = 0; u <= n; u++) {
            parents[u] = -1;
        }
    }

    static int getParentOf(int u) {
        if (parents[u] < 0) return u;
        return parents[u] = getParentOf(parents[u]);
    }

    static void unionParents(int u1, int u2) {
        int pu1 = getParentOf(u1);
        int pu2 = getParentOf(u2);

        if (pu1 != pu2) {
            if (parents[pu1] <= parents[pu2]) {
                parents[pu1] += parents[pu2];
                parents[pu2] = pu1;
            } else {
                parents[pu2] += parents[pu1];
                parents[pu1] = pu2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Edge> edges = new ArrayList<Edge>();

        for (int u = 1; u <= n; u++) {
            int weight = Integer.parseInt(br.readLine());
            edges.add(new Edge(0, u, weight));
        }

        for (int u1 = 1; u1 <= n; u1++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int u2 = 1; u2 < u1; u2++) {
                int weight = Integer.parseInt(st.nextToken());
                edges.add(new Edge(u2, u1, weight));
            }
        }

        Collections.sort(edges);
        int weightSum = 0;
        int edgeCount = 0;
        initParents(n);

        for (Edge edge : edges) {
            if (edgeCount == n) break;

            int pFrom = getParentOf(edge.from);
            int pTo = getParentOf(edge.to);

            if (pFrom == pTo) continue;

            unionParents(pFrom, pTo);
            weightSum += edge.weight;
            edgeCount++;
        }

        System.out.println(weightSum);
        br.close();
    }

}
