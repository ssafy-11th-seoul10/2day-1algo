package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ15664 {

    static int N, M;
    static int[] arr;

    static int[] combi;

    static StringBuilder sb;

    public static void combination(int depth, int start) {

        if(depth == M) {
            sb = new StringBuilder();
            for(int i = 0; i < M; i++)
                sb.append(combi[i]).append(" ");

            String res = sb.toString();
            System.out.println(res);
            return;
        }

        int flag = 0; // 중복되는 수열을 여러 번 출력하면 안되며

        for(int i = start; i < N; i++) {
            if(flag == arr[i] )
                continue;

            combi[depth] = arr[i];
            flag = arr[i];
            combination(depth+1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        combi = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        combination(0, 0);
    }

}
