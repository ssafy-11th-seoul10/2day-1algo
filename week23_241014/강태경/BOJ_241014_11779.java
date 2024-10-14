package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_241014_11779 {

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node>{
        int value;
        int dist;

        public Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if(this.dist==o.dist) return this.value - o.value;
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<ArrayList<Edge>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        StringTokenizer stk;
        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            edges.get(from).add(new Edge(to, cost));
        }
        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        int[] parent = new int[n + 1];
        parent[start] = start;
        while (!q.isEmpty()) {
            Node now = q.remove();
            int value = now.value;
            int dist = now.dist;

            if(distance[value]<dist) continue;
            for(Edge next: edges.get(value)){
                int cost = dist+next.cost;
                if(cost<distance[next.to]){
                    distance[next.to] = cost;
                    parent[next.to] = value;
                    q.add(new Node(next.to, cost));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(distance[end]).append("\n");
        int now = end;
        Deque<Integer> buf = new ArrayDeque<>();
        while(now!=start){
            buf.add(now);
            now = parent[now];
        }
        buf.add(start);
        sb.append(buf.size()).append("\n");
        while (!buf.isEmpty()) {
            sb.append(buf.removeLast()).append(" ");
        }
        System.out.println(sb);

    }
}
