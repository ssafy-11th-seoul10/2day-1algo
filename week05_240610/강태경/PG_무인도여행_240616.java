import java.util.*;

class PG_무인도여행_240616 {

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(Pair start) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(start);
        int sum = map[start.x][start.y]-'0';
        map[start.x][start.y] = 'X';
        while (!q.isEmpty()) {
            Pair now = q.remove();
            int x = now.x;
            int y = now.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]=='X') continue;
                sum+=map[nx][ny]-'0';
                map[nx][ny] = 'X';
                q.add(new Pair(nx, ny));
            }
        }
        answer.add(sum);
    }

    static char[][] map;
    static int n, m;
    static List<Integer> answer;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int[] solution(String[] maps) {
        answer = new ArrayList<>();

        n = maps.length;
        m = maps[0].length();

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 'X') {
                    bfs(new Pair(i, j));
                }
            }
        }
        if(answer.isEmpty()) answer.add(-1);
        else Collections.sort(answer);
        int[] arr = new int[answer.size()];
        for(int i=0; i<answer.size(); i++){
            arr[i] = answer.get(i);
        }
        return arr;
    }
}