package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ10655 {

    static int N;
    static int[][] position;

    public static int dist(int[] pos1, int[] pos2) {
        return Math.abs(pos1[0] - pos2[0]) + Math.abs(pos1[1] - pos2[1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        position = new int[N][2];
        int totalDist = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());

            if(i > 0)
                totalDist += dist(position[i], position[i - 1]);
        }

        // STEP 2. Brute-force
        int res = Integer.MAX_VALUE;

        for(int i = 1; i < N - 1; i++) {

            int tmp1 = dist(position[i-1], position[i]);
            int tmp2 = dist(position[i], position[i+1]);
            int newtmp = dist(position[i-1], position[i+1]);

            int getNewDist = totalDist - tmp1 - tmp2 + newtmp;
            res = Math.min(res, getNewDist);
        }

        System.out.println(res);
    }
}
