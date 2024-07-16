import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1647_240716 {

    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    static int find(int x) {
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = parent[x];
        y = parent[y];
        if(x==y) return;
        if(x>y){
            parent[x] = y;
        } else{
            parent[y] = x;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        //최소 신장 트리를 구하면서 가장 큰 간선의 비용을 저장
        //마지막에 가장 큰 간선을 빼준다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        PriorityQueue<Edge> edges = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            int cost = Integer.parseInt(stk.nextToken());
            edges.add(new Edge(x, y, cost));
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int maxCost = 0;
        int total = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.remove();
            int x = edge.x;
            int y = edge.y;
            int cost = edge.cost;
            if(find(x)!=find(y)){
                union(x, y);
                total+=cost;
                maxCost = Math.max(maxCost, cost);
            }
        }

        total -= maxCost;

        System.out.println(total);
    }
}
