package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ2491 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int maxi_len = 1;
        int mini_len = 1;
        int maxi_f = 1;
        int mini_f = 1;

        for(int i = 0; i < N - 1; i++) {

            int h = arr[i]; int t = arr[i+1];

            if(h < t) {
                mini_len = Math.max(mini_len, mini_f);
                mini_f = 1;

                maxi_f++;
            }

            else if(h > t) {
                maxi_len = Math.max(maxi_len, maxi_f);
                maxi_f = 1;

                mini_f++;
            }

            else {
                mini_f++;
                maxi_f++;
            }
        }
        // Edge Case : 1 1 1 1 1 ... => 같은 경우는 매번 갱신 X -> 한번에 하기
        maxi_len = Math.max(maxi_len, maxi_f);
        mini_len = Math.max(mini_len, mini_f);

        System.out.println(Math.max(maxi_len, mini_len));
    }
}
