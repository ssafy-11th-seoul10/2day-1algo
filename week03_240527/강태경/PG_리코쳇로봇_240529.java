import java.util.ArrayDeque;
import java.util.Deque;

public class PG_리코쳇로봇_240529 {

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
        boolean[][] visit = new boolean[r][c];
        visit[start.x][start.y] = true;
        q.add(start);
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int x = now.x;
            int y = now.y;
            int dist = now.dist;
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;
                while(true){
                    nx+=dx[i];
                    ny+=dy[i];
                    if(nx<0||ny<0||nx>=r||ny>=c||map[nx][ny]=='D'){
                        nx-=dx[i];
                        ny-=dy[i];
                        break;
                    }
                }
                if(map[nx][ny]=='G') {
                    answer = dist+1;
                    return;
                }
                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                q.add(new Pair(nx, ny, dist + 1));
            }
        }
    }

    static char[][] map;
    static int r, c, answer;
    static Pair start;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        String[] board = new String[] {".D.R", "....", ".G..", "...D"};
        r = board.length;
        c = board[0].length();
        map = new char[r][c];
        for (int i = 0; i <r ; i++) {
            map[i] = board[i].toCharArray();
            for (int j = 0; j < c; j++) {
                if(map[i][j]=='R') start = new Pair(i, j, 0);
            }
        }
        answer = -1;
        bfs();
        System.out.println(answer);
    }
}
