package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2167 {

    static int N, M;
    static int[][] matrix; static int[][] prefixSum;

    static int cnt;
    static List<int[]> command;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[N + 1][M + 1];
        prefixSum = new int[N + 1][M + 1];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < M + 1; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt =Integer.parseInt(br.readLine());
        command = new ArrayList<>();

        for(int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[4];
            for(int j=0; j < 4; j++)
                tmp[j] = Integer.parseInt(st.nextToken());

            command.add(tmp);
        }

        // STEP 2. PrefixSum Matrix 구하기
        for(int i = 1; i < N + 1; i++)
            for(int j = 1; j < M + 1; j++){
                prefixSum[i][j] = matrix[i][j] + prefixSum[i-1][j] +
                        prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }

        // STEP 3. print result

        for(int[] pos : command) {
            int sx = pos[0]; int sy = pos[1];
            int dx = pos[2]; int dy = pos[3];

            int result = prefixSum[dx][dy] - prefixSum[sx-1][dy] -
                    prefixSum[dx][sy-1] + prefixSum[sx -1][sy - 1];

            System.out.println(result);
        }
    }
}
