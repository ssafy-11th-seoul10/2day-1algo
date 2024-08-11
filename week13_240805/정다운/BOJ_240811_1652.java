package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1652 {

    static int N;
    static int garo_cnt = 0; static int sero_cnt = 0;
    static char[][] board;
    static boolean[][] garoVisited;
    static boolean[][] seroVisited;

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }

    public static boolean search(int sx, int sy, int dir) {

        int leng = 1;
        int x = sx; int y = sy;

        // garo
        if(dir == 0) {
            garoVisited[x][y] = true;
            while(inRange(x , y + 1) && board[x][y + 1] == '.') {
                leng++;
                garoVisited[x][y+1] = true; y++;
            }
        }
        // sero
        else {
            seroVisited[x][y] = true;
            while(inRange(x + 1, y) && board[x + 1][y] == '.') {
                leng++;
                seroVisited[x + 1][y] = true; x++;
            }
        }

        return leng > 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        garoVisited = new boolean[N][N]; seroVisited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < N; j++)
                board[i][j] = tmp.charAt(j);
        }

        for (int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                if(board[i][j] != '.')
                    continue;

                if(!garoVisited[i][j]) {
                  boolean garoFlag = search(i, j, 0);
                  if(garoFlag) {
                      garo_cnt++;
                  }
                }
                if(!seroVisited[i][j]) {
                  boolean seroFlag = search(i, j, 1);
                  if(seroFlag) {
                      sero_cnt++;
                  }
                }
            }

        System.out.println(garo_cnt + " " + sero_cnt);
    }
}
