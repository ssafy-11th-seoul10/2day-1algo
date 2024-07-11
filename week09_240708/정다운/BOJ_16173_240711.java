package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ16173 {

    static int N;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {1,0};
    static int[] dy = {0,1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }

    public static void dfs(int x, int y, int cnt) {

        if(cnt == 0) {
            if(!visited[x][y]) {
                visited[x][y] = true;

                if(board[x][y] > 0)
                    dfs(x, y, board[x][y]);
            }
            return;
        }

        if(inRange(x + cnt, y)) {
            dfs(x + cnt, y, 0);
        }
        if(inRange(x, y + cnt)) {
            dfs(x, y + cnt, 0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        visited[0][0] = true;
        dfs(0, 0, board[0][0]);

        if(visited[N-1][N-1])
            System.out.println("HaruHaru");
        else
            System.out.println("Hing");
    }

}
