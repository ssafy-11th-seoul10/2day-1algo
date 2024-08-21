import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_240819_2887 {

    static class Point {
        int u, x, y, z;

        Point(int u, int x, int y, int z) {
            this.u = u;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static Comparator<Point> xComparator = new Comparator<Point>() {

        @Override
        public int compare(Point o1, Point o2) {
            return Integer.compare(o1.x, o2.x);
        }

    };

    static Comparator<Point> yComparator = new Comparator<Point>() {

        @Override
        public int compare(Point o1, Point o2) {
            return Integer.compare(o1.y, o2.y);
        }

    };

    static Comparator<Point> zComparator = new Comparator<Point>() {

        @Override
        public int compare(Point o1, Point o2) {
            return Integer.compare(o1.z, o2.z);
        }

    };

    static int[] parent;

    static void initParent(int n) {
        parent = new int[n];

        for (int u = 0; u < n; u++) {
            parent[u] = -1;
        }
    }

    static int getParentOf(int u) {
        if (parent[u] < 0)
            return u;
        return parent[u] = getParentOf(parent[u]);
    }
    
    static void unionParents(int u1, int u2) {
        int pu1 = getParentOf(u1);
        int pu2 = getParentOf(u2);

        if (pu1 != pu2) {
            if (parent[pu1] <= parent[pu2]) {
                parent[pu1] += parent[pu2];
                parent[pu2] = pu1;
            } else {
                parent[pu2] += parent[pu1];
                parent[pu1] = pu2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];

        for (int u = 0; u < n; u++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            points[u] = new Point(u, x, y, z);
        }

        ArrayList<Edge> edges = new ArrayList<Edge>();
        Arrays.sort(points, xComparator);

        for (int u = 1; u < n; u++) {
            edges.add(new Edge(points[u - 1].u, points[u].u, Math.abs(points[u - 1].x - points[u].x)));
        }

        Arrays.sort(points, yComparator);

        for (int u = 1; u < n; u++) {
            edges.add(new Edge(points[u - 1].u, points[u].u, Math.abs(points[u - 1].y - points[u].y)));
        }

        Arrays.sort(points, zComparator);

        for (int u = 1; u < n; u++) {
            edges.add(new Edge(points[u - 1].u, points[u].u, Math.abs(points[u - 1].z - points[u].z)));
        }

        Collections.sort(edges);
        initParent(n);
        int edgeCount = 0;
        int weightSum = 0;

        for (Edge edge : edges) {
            if (edgeCount == n - 1) break;

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
