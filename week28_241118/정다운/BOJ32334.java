package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ32334 {

    static int N, D;
    static int[][] board;

    static int[] dx = {-1,-1,-1,0,1,1,1,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1};

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // prefix-sum
        int[][] prefixSum = new int[N + 1][N + 1];
        int count = N*N;
        boolean isZero = false;
        int rx = 0; int ry = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                prefixSum[i][j] = board[i-1][j-1];
                prefixSum[i][j] += ( prefixSum[i-1][j]
                            + prefixSum[i][j-1] - prefixSum[i-1][j-1]);
            }
        }

        outer : for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(board[i - 1][j - 1] == 1)
                    continue;

                int sx = i - D; int sy = j - D;
                int tx = i + D; int ty = j + D;

                if(sx < 1) sx = 1;
                if(sy < 1) sy = 1;
                if(tx > N) tx = N;
                if(ty > N) ty = N;

                int result = prefixSum[tx][ty] - prefixSum[sx - 1][ty]
                        - prefixSum[tx][sy - 1] + prefixSum[sx - 1][sy - 1];

                if(result == 0) {
                    rx = i; ry = j;
                    isZero = true;
                    break outer;
                }
                else {
                    if(count > result) {
                        count = result;
                        rx = i; ry = j;
                    }
                }
            }
        }

        System.out.println((rx) + " " + (ry));
        if(!isZero)
            System.out.println(count);
    }
}
