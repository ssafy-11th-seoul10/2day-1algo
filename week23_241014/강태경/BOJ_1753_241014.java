package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753_241014 {

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node>{
        int dist;
        int value;

        public Node(int dist, int value) {
            this.dist = dist;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if(this.dist ==o.dist) return this.value - o.value;
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(br.readLine());
        List<ArrayList<Edge>> edges = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            edges.get(from).add(new Edge(to, cost));
        }

        int[] distance = new int[v+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, k));
        while(!q.isEmpty()){
            Node now = q.remove();
            int value = now.value;
            int dist = now.dist;
            if(distance[value]< dist) continue;
            for (Edge edge : edges.get(value)) {
                int cost = dist + edge.cost;
                int to = edge.to;
                if (distance[to] > cost) {
                    distance[to] = cost;
                    q.add(new Node(cost, to));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=v; i++) {
            if (distance[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(distance[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
