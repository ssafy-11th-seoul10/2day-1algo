package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_241016_1446 {

    static class Road implements Comparable<Road>{
        int start;
        int end;
        int dist;

        public Road(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Road o) {
            if(this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());

        int[] dp = new int[d+1];
        for (int i = 0; i <= d; i++) {
            dp[i] = i;
        }

        PriorityQueue<Road> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            if(end>d) continue;
            int dist = Integer.parseInt(stk.nextToken());
            q.add(new Road(start, end, dist));
        }
        while (!q.isEmpty()) {
            Road road = q.remove();
            int start = road.start;
            int end = road.end;
            int dist = road.dist;
            if(dp[end]>dp[start]+dist){
                dp[end] = dp[start] + dist;
                for (int i = end+1; i <=d ; i++) {
                    dp[i] = Math.min(dp[end]+i-end, dp[i]);
                }
            }
        }
        System.out.println(dp[d]);
    }
}
