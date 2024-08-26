import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_240824_13418 {

    static class Road {
        int from, to;

        Road(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static int[] parent;

    static void initParent(int n) {
        parent = new int[n];

        for (int u = 0; u < n; u++) {
            parent[u] = -1;
        }
    }

    static int getParentOf(int u) {
        if (parent[u] < 0) return u;
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;

        ArrayList<Road> upRoads = new ArrayList<Road>();
        ArrayList<Road> downRoads = new ArrayList<Road>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (c == 0) {
                upRoads.add(new Road(a, b));
            } else {
                downRoads.add(new Road(a, b));
            }
        }

        initParent(n);
        int upRoadCount = 0;

        for (Road road : upRoads) {
            int pFrom = getParentOf(road.from);
            int pTo = getParentOf(road.to);

            if (pFrom == pTo) continue;

            unionParents(pFrom, pTo);
            upRoadCount++;
        }

        initParent(n);
        int downRoadCount = 0;

        for (Road road : downRoads) {
            int pFrom = getParentOf(road.from);
            int pTo = getParentOf(road.to);

            if (pFrom == pTo) continue;

            unionParents(pFrom, pTo);
            downRoadCount++;
        }

        int ans = upRoadCount * upRoadCount - (n - 1 - downRoadCount) * (n - 1 - downRoadCount);
        System.out.println(ans);
        br.close();
    }

}
