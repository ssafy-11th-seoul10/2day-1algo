package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2740 {

    static int an, am;
    static int[][] A;
    static int bm, bk;
    static int[][] B;

    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        an = Integer.parseInt(st.nextToken()); am = Integer.parseInt(st.nextToken());
        A = new int[an][am];

        for(int col = 0; col < an; col++) {
            st = new StringTokenizer(br.readLine());

            for(int row = 0; row < am; row++)
                A[col][row] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        bm = Integer.parseInt(st.nextToken()); bk = Integer.parseInt(st.nextToken());
        B = new int[bm][bk];

        for(int col = 0; col < bm; col++) {
            st = new StringTokenizer(br.readLine());

            for(int row = 0; row < bk; row++)
                B[col][row] = Integer.parseInt(st.nextToken());
        }

        result = new int[an][bk];

        for(int c = 0; c < an; c++)
            for(int r = 0; r < bk; r++) {

                int res = 0;

                for(int j = 0; j < am; j++)
                    res += (A[c][j] * B[j][r]);

                result[c][r] = res;
            }

        StringBuilder sb = new StringBuilder();
        for(int c = 0; c < an; c++) {
            for(int r = 0; r < bk; r++)
                sb.append(result[c][r]).append(" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
