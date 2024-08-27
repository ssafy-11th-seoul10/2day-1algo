import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_240828_1414 {

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
        parents = new int[n];

        for (int u = 0; u < n; u++) {
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
        int n = Integer.parseInt(br.readLine());
        ArrayList<Edge> edges = new ArrayList<Edge>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);

                if (c == '0') {
                    continue;
                } else if (c <= 'Z') {
                    edges.add(new Edge(i, j, c - 'A' + 27));
                } else {
                    edges.add(new Edge(i, j, c - 'a' + 1));
                }
            }
        }

        Collections.sort(edges);
        initParents(n);
        int unusedWeightSum = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            int pFrom = getParentOf(edge.from);
            int pTo = getParentOf(edge.to);

            if (pFrom == pTo) {
                unusedWeightSum += edge.weight;
                continue;
            }

            unionParents(pFrom, pTo);
            edgeCount++;
        }

        System.out.println(edgeCount == n - 1 ? unusedWeightSum : -1);
        br.close();
    }

}
