package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1303 {
    static char map[][];
    static boolean visit[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int N, M;
    static long sum;
    static long white, black;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        white = 0;
        black = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new char[M][N];
        visit = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {  // 방문하지 않은 노드에 대해서만 탐색 수행
                    sum = 0;
                    force(i, j, map[i][j]);
                    if (map[i][j] == 'B') {
                        black += sum * sum;
                    }
                    if (map[i][j] == 'W') {
                        white += sum * sum;
                    }
                }
            }
        }
        System.out.println(white + " " + black);
    }
    
    static void force(int x, int y, char a) {
        if (visit[x][y]) {
            return;
        }
        visit[x][y] = true;
        sum++;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visit[nx][ny] && map[nx][ny] == a) {
                force(nx, ny, a);
            }
        }
    }
}
