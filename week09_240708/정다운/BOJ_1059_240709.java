package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1059 {

    static int L, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());
        arr = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < L; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0; int end = 0;

        // Edge case : N = 2, arr = { 7, 8, 9 }
        // [1,2], [1,3], [1,4], [1,5], [1,6], [2,3], [2,4], [2,5], [2,6]
        if(N < arr[0]) {
            start = 0; end = arr[0];
        }
        else {

            for(int j = 0; j < L - 1; j++) {
                if(arr[j] < N && N < arr[j + 1]) {
                    start = arr[j]; end = arr[j + 1];
                    break;
                }
            }
        }

        int cnt = 0;

        for (int head = start + 1; head <= N; head++)
            for (int tail = N; tail < end; tail++) {

                    if (head == tail) continue;
                    cnt++;
                }

        System.out.println(cnt);
    }
}
