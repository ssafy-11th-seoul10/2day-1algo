package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_241025_20303 {

    static void bfs(int start){
        visit[start] = true;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);

        int count = 1;
        int total = candy[start];
        while (!q.isEmpty()) {
            int now = q.remove();
            for (int next : edges.get(now)) {
                if (!visit[next]) {
                    visit[next] = true;
                    count++;
                    total += candy[next];
                    q.add(next);
                }
            }
        }
        newCandy.add(total);
        size.add(count);
    }


    static List<ArrayList<Integer>> edges;
    static int[] candy;
    static List<Integer> newCandy, size;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        candy = new int[n + 1];

        stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            candy[i] = Integer.parseInt(stk.nextToken());
        }

        edges = new ArrayList<>();

        for (int i = 0; i <=n; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i <m ; i++) {
            stk = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(stk.nextToken());
            int second = Integer.parseInt(stk.nextToken());
            edges.get(first).add(second);
            edges.get(second).add(first);
        }

        visit = new boolean[n + 1];
        newCandy = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            if (!visit[i]) {
                bfs(i);
            }
        }

        int[] d = new int[k];

        for (int i = 0; i <newCandy.size() ; i++) {
            for (int j = k-1; j>=1  ; j--) {
                if(j>=size.get(i)){
                    d[j] = Math.max(d[j], d[j - size.get(i)] + newCandy.get(i));
                }
            }
        }
        System.out.println(d[k-1]);

    }
}
