package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_241016_10282 {

    static class Node implements Comparable<Node>{
        int value;
        int dist;

        public Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            List<ArrayList<Edge>> edges = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < d; i++) {
                stk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());
                int s = Integer.parseInt(stk.nextToken());
                edges.get(b).add(new Edge(a, s));
            }
            int[] distance = new int[n + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[c] = 0;
            int time = 0;
            int count = 0;
            PriorityQueue<Node> q = new PriorityQueue<>();
            q.add(new Node(c, 0));
            while (!q.isEmpty()) {
                Node now = q.remove();
                int value = now.value;
                int dist = now.dist;
                if(dist>distance[value]) continue;
                count++;
                time = dist;
                for(Edge next : edges.get(value)){
                    int cost = dist + next.cost;
                    if(cost<distance[next.to]){
                        distance[next.to] = cost;
                        q.add(new Node(next.to, cost));
                    }
                }
            }
            sb.append(count).append(" ").append(time).append("\n");
        }
        System.out.println(sb);
    }
}
