package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1996 {

    static int N;
    static char[][] board;

    static int[] dx = {-1,-1,-1,0, 1,1,1,0};
    static int[] dy = {-1,0,1,1, 1,0,-1,-1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }

    static char[][] resBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N]; resBoard = new char[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for(int j = 0; j < N; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        // resBoard 채우기
        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                if(board[i][j] != '.')
                    resBoard[i][j] = '*';
                else {

                    int cnt = 0;
                    for(int k = 0; k < 8; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(inRange(nx, ny) && board[nx][ny] != '.')
                            cnt += board[nx][ny] - '0';
                    }

                    if(cnt >= 10)
                        resBoard[i][j] = 'M';
                    else
                        resBoard[i][j] = (char)(cnt + '0');
                }
            }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++)
            sb.append(resBoard[i]).append("\n");

        System.out.println(sb);
    }
}
