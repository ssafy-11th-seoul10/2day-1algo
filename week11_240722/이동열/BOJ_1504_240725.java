package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1504 {

    private static int N, E;
    private static final int INF = 100_000_000;
    private static List<Pair>[] lst;

    private static class Pair implements Comparable<Pair> {
        int cost, node;

        Pair(int cost, int node) {
            this.cost = cost;
            this.node = node;
        }

        @Override
        public int compareTo(Pair p) {
            return this.cost - p.cost;
        }
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        pq.add(new Pair(0, start));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int cost = curr.cost;
            int s = curr.node;

            if (cost > dist[s]) continue;

            for (Pair next : lst[s]) {
                if (next.cost + cost < dist[next.node]) {
                    dist[next.node] = next.cost + cost;
                    pq.add(new Pair(next.cost + cost, next.node));
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        lst = new List[N+1];

        for (int i = 0; i <=N; i++) {
            lst[i] = new ArrayList<>();
        }
        for (int i = 0; i <E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            lst[a].add(new Pair(c, b));
            lst[b].add(new Pair(c, a));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = dijkstra(1,v1) + dijkstra(v1,v2) + dijkstra(v2,N);
        int ans2 = dijkstra(1,v2) + dijkstra(v2,v1) + dijkstra(v1,N);
        int answer = Math.min(ans1,ans2);
        System.out.println(answer>=INF ? -1 : answer);
    }

}
