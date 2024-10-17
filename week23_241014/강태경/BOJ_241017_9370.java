package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_241017_9370 {

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node> {
        int value;
        int dist;

        public Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist == o.dist) return this.value - o.value;
            return this.dist - o.dist;
        }
    }

    static void dijkstra(int[] distance, int start) {
        Arrays.fill(distance, 100_000_000);
        distance[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node now = q.remove();
            int value = now.value;
            int dist = now.dist;

            if (dist > distance[value]) continue;

            for (Edge edge : edges.get(value)) {
                int next = edge.to;
                int cost = dist + edge.cost;
                if (cost < distance[next]) {
                    distance[next] = cost;
                    q.add(new Node(next, cost));
                }
            }
        }
    }

    static List<ArrayList<Edge>> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int t = Integer.parseInt(stk.nextToken());

            stk = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(stk.nextToken());
            int g = Integer.parseInt(stk.nextToken());
            int h = Integer.parseInt(stk.nextToken());

            edges = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                stk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                int d = Integer.parseInt(stk.nextToken());
                edges.get(a).add(new Edge(b, d));
                edges.get(b).add(new Edge(a, d));
            }
            int[] goals = new int[t];
            for (int i = 0; i < t; i++) {
                goals[i] = Integer.parseInt(br.readLine());
            }

            int[] distanceS = new int[n + 1];
            int[] distanceG = new int[n + 1];
            int[] distanceH = new int[n + 1];
            dijkstra(distanceS, s);
            dijkstra(distanceG, g);
            dijkstra(distanceH, h);

            int distGH = 0;
            for (Edge edge : edges.get(g)) {
                if(edge.to==h){
                    distGH = edge.cost;
                    break;
                }
            }
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 0; i < t; i++) {
                int goal = goals[i];
                int total = Math.min(distanceS[g] + distGH + distanceH[goal], distanceS[h] + distGH + distanceG[goal]);
                if(total==distanceS[goal]) q.add(goal);
            }

            while (!q.isEmpty()) {
                sb.append(q.remove()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
