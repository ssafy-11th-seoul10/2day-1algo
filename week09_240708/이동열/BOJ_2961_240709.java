package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class BOJ2961 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            int lth = 1<<N;
            int answer = Integer.MAX_VALUE;
            for (int i = 1; i < lth; i++) {
                int S = 1;
                int B = 0;
                for (int j = 0; j < N; j++) {
                    if((i & 1<<j)>0){
                        S*=arr[j][0];
                        B+=arr[j][1];
                    }
                }
                answer = Math.min(answer,Math.abs(S-B));
            }
            System.out.println(answer);
        }
}
