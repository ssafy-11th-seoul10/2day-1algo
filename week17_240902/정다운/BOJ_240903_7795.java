package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ7795 {

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N]; int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++)
                B[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(A); Arrays.sort(B);

            int aPointer = 0; int bPointer = 0;
            int cnt = 0;

            while(aPointer < N) {

                while(bPointer < M && A[aPointer] > B[bPointer])
                    bPointer++;

                //System.out.println(aPointer + " " + bPointer);
                cnt += (bPointer);
                aPointer++;
            }

            System.out.println(cnt);
        }
    }
}
