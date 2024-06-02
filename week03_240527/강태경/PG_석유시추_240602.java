import java.util.*;

public class PG_석유시추_240602 {

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int bfs(Pair start, int num){
        Deque<Pair> q = new ArrayDeque<>();
        q.add(start);
        int size = 1;
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int x = now.x;
            int y = now.y;

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m||land[nx][ny]!=1) continue;
                land[nx][ny] = num;
                size++;
                q.add(new Pair(nx, ny));
            }
        }
        return size;
    }


    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] land;

    public static void main(String[] args) throws Exception {

        land = new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        n = land.length;
        m = land[0].length;
        int num = 2;
        Map<Integer, Integer> sizeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    land[i][j] = num;
                    int size = bfs(new Pair(i, j),num);
                    sizeMap.put(num, size);
                    num++;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new TreeSet<>();
            int buf = 0;
            for (int j = 0; j < n; j++) {
                if(land[j][i]!=0) set.add(land[j][i]);
            }
            for (int idx : set) {
                buf += sizeMap.get(idx);
            }
            answer = Math.max(answer, buf);
        }
        System.out.println(answer);
    }
}