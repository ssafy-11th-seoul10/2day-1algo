package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ19941 {

    static int N, K;
    static String data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = br.readLine();
        int cnt = 0;
        boolean[] visited = new boolean[N];

        for(int i = 0; i < N; i++) {

            if(data.charAt(i) == 'P') {

                boolean hamburger = false;

                for(int j = K; j > -1; j--) {
                    int left = i - j;

                    if(0 <= left && data.charAt(left) == 'H' && !visited[left]) {
                        visited[left] = true;
                        cnt++;
                        hamburger = true;
                        break;
                    }
                }

                if(!hamburger) {
                for(int j = 1; j <= K; j++) {
                    int right = i + j;

                    if(N > right && data.charAt(right) == 'H' && !visited[right]) {
                        visited[right] = true;
                        cnt++;
                        break;
                    }
                }
                }

            }
        }

        System.out.println(cnt);
    }
}
