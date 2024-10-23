package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241023_14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int t = Integer.parseInt(stk.nextToken());

        int[] time = new int[n + 1];
        int[] score = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stk = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(stk.nextToken());
            score[i] = Integer.parseInt(stk.nextToken());
        }
        int[] d = new int[t+1];

        for (int i = 1; i <= n; i++) {
            for (int j = t; j >= 1; j--) {
                if(j>=time[i]){
                    d[j] = Math.max(d[j], d[j - time[i]] + score[i]);
                }
            }
        }
        System.out.println(d[t]);
    }
}
