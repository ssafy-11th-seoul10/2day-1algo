package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_241021_2211 {

    static class Node implements Comparable<Node>{

        int from;
        int value;
        int dist;

        public Node(int from, int value, int dist) {
            this.from = from;
            this.value = value;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        List<ArrayList<Edge>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            edges.get(a).add(new Edge(b, cost));
            edges.get(b).add(new Edge(a, cost));
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        List<Node> nodes = new ArrayList<>();

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 1, 0));
        while (!q.isEmpty()) {
            Node now = q.remove();
            int value = now.value;
            int dist = now.dist;

            if(distance[value]<dist) continue;
            nodes.add(now);
            for (Edge edge : edges.get(value)) {
                int to = edge.to;
                int cost = dist + edge.cost;
                if(cost<distance[to]){
                    distance[to] = cost;
                    q.add(new Node(value, to, cost));
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(nodes.size()-1).append("\n");
        for (int i=1; i< nodes.size(); i++) {
            Node node = nodes.get(i);
            sb.append(node.from).append(" ").append(node.value).append("\n");
        }
        System.out.println(sb);
    }
}
