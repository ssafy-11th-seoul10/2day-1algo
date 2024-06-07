import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13565 {

    public static int N, M;
    public static int[][] graph;
    static boolean[][] visited;

    static List<int[]> start_pos;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < M);
    }

    public static boolean bfs() {

        Queue<int[]> queue = new ArrayDeque<>();

        for(int[] pos : start_pos) {
            int x = pos[0]; int y = pos[1];
            visited[x][y] = true;
            queue.add(pos);
        }

        while (!queue.isEmpty()) {

            int[] curr_pos = queue.poll();
            int x = curr_pos[0]; int y = curr_pos[1];

            if(x == N - 1)
                return true;

            for(int i = 0; i < 4; i++) {

                int nx = x + dx[i]; int ny = y + dy[i];

                if(inRange(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];
        start_pos = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String row = br.readLine();

            for(int j = 0; j < M; j++) {
                int tmp = row.charAt(j) - '0';

                if(i == 0 && tmp == 0)
                    start_pos.add(new int[] {i, j});

                graph[i][j] = tmp;
            }
        }

        /// Simulation
        boolean Result = bfs();

        if(Result)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
