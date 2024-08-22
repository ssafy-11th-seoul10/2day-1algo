package PG;

import java.util.ArrayDeque;
import java.util.Deque;

public class PG_게임맵최단거리_240822 {

    static class Pair{
        int x;
        int y;
        int dist;

        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static void bfs(){
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, 1));
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int x = now.x;
            int y = now.y;
            int dist = now.dist;
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||ny<0||nx>=map.length||ny>=map[0].length||map[nx][ny]==0) continue;
                if(nx==map.length-1&&ny==map[0].length-1){
                    answer = dist+1;
                    return;
                }
                map[nx][ny] = 0;
                q.add(new Pair(nx, ny, dist + 1));
            }

        }
    }

    static int answer;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        map = maps.clone();
        answer = -1;
        bfs();
        System.out.println(answer);
    }
}
