import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1647 {

    private static int[] parent;

    private static class Node implements Comparable<Node>{
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    private static int find(int x){
        while (parent[x] != x){
            x = parent[x];
        }
        return x;
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node> lst = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lst.add(new Node(x,y,cost));
        }
        Collections.sort(lst);
        parent = new int[N+1];
        for (int i = 1; i <=N; i++) {
            parent[i] = i;
        }
        int max = 0;
        int answer = 0;
        for(Node w : lst) {
            int x = w.x;
            int y = w.y;
            int cost = w.cost;
            if (find(x) != find(y)) {
                union(x, y);
                max = Math.max(max, cost);
                answer += cost;
            }
        }
        answer-=max;
        System.out.println(answer);
    }

}
