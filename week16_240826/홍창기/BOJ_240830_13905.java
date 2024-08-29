import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_240830_13905 {

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return o.weight - this.weight;
        }
    }

    static int[] parents;

    static void initParents(int n) {
        parents = new int[n + 1];

        for (int u = 1; u <= n; u++) {
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edges);
        int low = 0; // true
        int high = 1000001; // false

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            initParents(n);

            for (Edge edge : edges) {
                if (edge.weight < mid) break;

                int pFrom = getParentOf(edge.from);
                int pTo = getParentOf(edge.to);

                if (pFrom == pTo) continue;

                unionParents(pFrom, pTo);
            }

            if (getParentOf(s) == getParentOf(e)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
        br.close();
    }

}
