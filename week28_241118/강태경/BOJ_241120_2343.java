package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_241120_2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        List<Integer> list = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            list.add(num);
            maxSize = Math.max(maxSize, num);
        }

        int start = maxSize;
        int end = 1_000_000_000;
        int answer = end;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                sum += list.get(i);
                if (sum > mid) {
                    cnt++;
                    if (i == n - 1) cnt++;
                    else sum = list.get(i);
                } else if (sum == mid) {
                    cnt++;
                    sum = 0;
                } else {
                    if (i == n - 1) cnt++;
                }
            }

            if (m >= cnt) {
                end = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
