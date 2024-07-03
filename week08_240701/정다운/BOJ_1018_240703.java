package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1018 {

    static int res = Integer.MAX_VALUE;

    static char[][] board;
    static int N, M;

    static char[][] whiteBoard = {
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
    };

    static char[][] blackBoard = {
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for(int j = 0; j < M; j++)
                board[i][j] = tmp.charAt(j);
        }

        // STEP 2. Brute Force
        for(int i = 0; i < N - 8 + 1; i++)
            for(int j = 0; j < M - 8 + 1; j++) {

                int white_cnt = 0;
                int black_cnt = 0;

                    for(int x = 0; x < 8; x++)
                        for(int y = 0; y < 8; y++) {

                            if(board[i + x][j + y] != whiteBoard[x][y])
                                white_cnt++;
                        }


                    for(int x = 0; x < 8; x++)
                        for(int y = 0; y < 8; y++) {

                            if(board[i + x][j + y] != blackBoard[x][y])
                                black_cnt++;
                        }

                int cnt = Math.min(white_cnt, black_cnt);
                res = Math.min(res, cnt);
            }

        System.out.println(res);
    }
}
