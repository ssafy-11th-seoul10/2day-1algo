package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_241014_18352 {

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
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());

        List<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            edges.get(from).add(to);
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[x] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(x, 0));

        while (!q.isEmpty()) {
            Node now = q.remove();
            int value = now.value;
            int dist = now.dist;

            if(dist<distance[value]) continue;

            for (int next : edges.get(value)) {
                int cost = dist+1;
                if(cost<distance[next]){
                    distance[next] = cost;
                    q.add(new Node(next, cost));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=n ; i++) {
            if(distance[i]==k){
                sb.append(i).append("\n");
            }
        }
        if(sb.length()==0) sb.append(-1);
        System.out.println(sb);
    }
}
