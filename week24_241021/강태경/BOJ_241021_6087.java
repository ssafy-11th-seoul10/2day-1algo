package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_241021_6087 {

    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int dist;
        int direction;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public Pair(int x, int y, int dist, int direction) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.direction = direction;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //각도를 변경하면 거울을 사용한 것
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());

        char[][] map = new char[h][w];
        Pair start = null;
        Pair end = null;
        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if(map[i][j]=='C'){
                    if (start == null) {
                        start = new Pair(i, j, -1);
                    } else {
                        end = new Pair(i, j, Integer.MAX_VALUE);
                    }
                }
            }
        }
        int[][] distance = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[start.x][start.y] = 0;

        //0:우, 1:하, 2:좌, 3:상
        //가로: 0, 2
        //세로: 1, 3
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        //0: 가로, 1: 세로
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start.x, start.y, 0, 0));
        q.add(new Pair(start.x, start.y, 0, 1));
        boolean[][][] visit = new boolean[h][w][2];
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int x = now.x;
            int y = now.y;
            int dist = now.dist;
            int direction = now.direction;
            if(visit[x][y][direction]) continue;
            visit[x][y][direction] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||ny<0||nx>=h||ny>=w||map[nx][ny]=='*') continue;
                int cost = dist;
                int ndirection = i%2;
                if(direction!=ndirection) cost++;
                if(distance[nx][ny]>=cost && !visit[nx][ny][ndirection]){
                    distance[nx][ny] = cost;
                    q.add(new Pair(nx, ny, cost, ndirection));
                }
            }
        }
        System.out.println(distance[end.x][end.y]);

    }
}
