package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_241016_2665 {

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        //출발지점으로부터 각 방까지의 최단 경로를 검정방을 지나치는 개수로 정한다.
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node now = q.remove();
            int x = now.x;
            int y = now.y;
            int dist = now.dist;
            if(dist>distance[x][y]) continue;
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                int ndist = dist;
                if(map[nx][ny]=='0') ndist++;
                if(distance[nx][ny]>ndist){
                    distance[nx][ny] = ndist;
                    q.add(new Node(nx, ny, ndist));
                }
            }
        }
        System.out.println(distance[n-1][n-1]);
    }
}
