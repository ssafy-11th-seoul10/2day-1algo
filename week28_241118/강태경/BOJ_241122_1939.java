package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_241122_1939 {

    static class Node{
        int to;
        int limit;

        public Node(int to, int limit) {
            this.to = to;
            this.limit = limit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        List<ArrayList<Node>> nodes = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(stk.nextToken());
            int second = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());
            nodes.get(first).add(new Node(second, dist));
            nodes.get(second).add(new Node(first, dist));
        }
        stk = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(stk.nextToken());
        int second = Integer.parseInt(stk.nextToken());

        int answer = 1;

        int start = 1;
        int end = 1_000_000_000;
        while (start <= end) {
            int mid = (start+end)/2;

            boolean possible = false;
            boolean[] visit = new boolean[n+1];
            Deque<Integer> q = new ArrayDeque<>();
            q.add(first);
            visit[first] = true;
            while (!q.isEmpty()) {
                int now = q.remove();
                for (Node node : nodes.get(now)) {
                    if(visit[node.to] || node.limit<mid) continue;
                    if(node.to==second){
                        possible = true;
                        break;
                    }
                    visit[node.to] = true;
                    q.add(node.to);
                }
                if(possible) break;
            }
            if(possible){
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
