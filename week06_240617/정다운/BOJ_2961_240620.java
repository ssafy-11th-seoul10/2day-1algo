package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2961 {

    static int N;
    static int[][] gradients;
    static boolean[] selected;

    static int min_val = Integer.MAX_VALUE;

    public static void subSet(int depth) {
        if(depth == N) {

            int sour = 1; // 신맛
            int bitter = 0; // 쓴맛
            int cnt = 0;

            for(int i = 0; i < N; i++) {
                if (selected[i]) {
                    sour *= gradients[i][0];
                    bitter += gradients[i][1];
                } else
                    cnt++;
            }

            if(cnt == N) return;

            int chai = Math.abs(bitter - sour);
            min_val = Math.min(min_val, chai);

            return;
        }

        selected[depth] = true;
        subSet(depth + 1);

        selected[depth] = false;
        subSet(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        gradients = new int[N][2];
        selected = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());

            gradients[i][0] = sour; gradients[i][1] = bitter;
        }

        subSet(0);

        System.out.println(min_val);
    }
}
