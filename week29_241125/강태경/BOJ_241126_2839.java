package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_241126_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];
        Arrays.fill(d, -1);
        d[0] = 0;
        d[3] = 1;

        for (int i = 5; i <= n; i++) {
            if (d[i - 3] == -1) {
                if (d[i - 5] != -1) {
                    d[i] = d[i - 5] + 1;
                }
            } else {
                if (d[i - 5] == -1) {
                    d[i] = d[i - 3] + 1;
                } else {
                    d[i] = Math.min(d[i - 3], d[i - 5]) + 1;
                }
            }
        }

        System.out.println(d[n]);
    }
}
