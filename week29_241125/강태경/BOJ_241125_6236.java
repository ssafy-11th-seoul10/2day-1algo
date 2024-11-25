package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241125_6236 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            maxValue = Math.max(maxValue, arr[i]);
        }

        int answer = 1000_000_000;

        int start = maxValue;
        int end = 1000_000_000;

        while (start <= end) {
            int mid = (start + end) / 2;
            int cnt = 1;
            int balance = mid;
            for (int i = 0; i < n; i++) {
                int now = arr[i];
                if (now > balance) {
                    balance = mid-now;
                    cnt++;
                } else {
                    balance -= now;
                }
            }
            if (cnt <= m) {
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
