package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_241120_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if (num >= 0) plusList.add(num);
            else minusList.add(num);
        }
        int first = 0;
        int second = 0;
        StringBuilder sb = new StringBuilder();
        Collections.sort(minusList);
        Collections.sort(plusList);
        int value = Integer.MAX_VALUE;
        if (minusList.size() >= 2 && value > minusList.get(minusList.size() - 2) + minusList.get(minusList.size() - 1)) {
            first = minusList.get(minusList.size() - 2);
            second = minusList.get(minusList.size() - 1);
            value = Math.abs(first + second);
        }
        if (plusList.size() >= 2 && value > plusList.get(0) + plusList.get(1)) {
            first = plusList.get(0);
            second = plusList.get(1);
            value = first + second;
        }
        for (Integer i : plusList) {
            int num = i * (-1);
            int start = 0;
            int end = minusList.size() - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int now = minusList.get(mid);
                int buf = Math.abs(now + i);
                if (buf < value) {
                    first = now;
                    second = i;
                    value = buf;
                }
                if (now < num) {
                    start = mid + 1;
                } else if (now > num) {
                    end = mid - 1;
                } else {
                    break;
                }
            }
        }
        sb.append(first).append(" ").append(second);
        System.out.println(sb);
    }
}
