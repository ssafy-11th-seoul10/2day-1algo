import java.util.*;

class PG_미로탈출_240611 {

    static class Pair{
        int x;
        int y;
        int key;
        int dist;

        public Pair(int x, int y, int key, int dist) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.dist = dist;
        }
    }

    static void bfs(Pair start){
        Deque<Pair> q = new ArrayDeque<>();
        boolean[][][] visit = new boolean[r][c][2];
        q.add(start);
        visit[start.x][start.y][0] = true;
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int x = now.x;
            int y = now.y;
            int key = now.key;
            int dist = now.dist;
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||ny<0||nx>=r||ny>=c||map[nx][ny]=='X'||visit[nx][ny][key]) continue;
                if(key==1&&map[nx][ny]=='E'){
                    result = dist+1;
                    return;
                }
                if(map[nx][ny]=='L') {
                    visit[nx][ny][1] = true;
                    q.add(new Pair(nx, ny, 1, dist + 1));
                }
                visit[nx][ny][key] = true;
                q.add(new Pair(nx, ny, key, dist + 1));
            }

        }
    }

    static char[][] map;
    static int r, c, result;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int solution(String[] maps) {
        r = maps.length;
        c = maps[0].length();
        map = new char[r][c];
        Pair start = null;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j]=='S') start = new Pair(i, j, 0,0);
            }
        }

        result = Integer.MAX_VALUE;
        bfs(start);
        if(result==Integer.MAX_VALUE) return -1;
        else return result;
    }
}