package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_241121_2143 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n + 1];
        int[] prefixA = new int[n + 1];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        // A 누적합
        for (int i = 1; i < n + 1; i++) {
            arrA[i] = Integer.parseInt(stk.nextToken());
            prefixA[i] = prefixA[i - 1] + arrA[i];
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m + 1];
        int[] prefixB = new int[m + 1];
        stk = new StringTokenizer(br.readLine());

        // B 누적합
        for (int i = 1; i < m + 1; i++) {
            arrB[i] = Integer.parseInt(stk.nextToken());
            prefixB[i] = prefixB[i - 1] + arrB[i];
        }

        // B 조합의 경우 List
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < m + 1; i++) {
            for (int j = i; j < m + 1; j++) {
                list.add(prefixB[j] - prefixB[i - 1]);
            }
        }
        long cnt = 0L;
        Collections.sort(list);
        // 1. A 조합 경우
        for (int i = 1; i < n + 1; i++) {
            for (int j = i; j < n + 1; j++) {
                int sumA = prefixA[j] - prefixA[i - 1];

                // 2. B 조합 List 이분탐색
                int findNum = t - sumA;
                int leftIdx = -1;
                int rightIdx = -1;
                int start = 0;
                int end = list.size();
                while (start < end) {
                    int mid = (start + end) / 2;
                    int now = list.get(mid);
                    if (now >= findNum) {
                        end = mid;
                        if(now==findNum) {
                            leftIdx = mid;
                        }
                    } else {
                        start = mid + 1;
                    }
                }

                start = 0;
                end = list.size();
                while (start < end) {
                    int mid = (start + end) / 2;
                    int now = list.get(mid);
                    if (now <= findNum) {
                        start = mid+1;
                        if(now==findNum) {
                            rightIdx = mid;
                        }
                    } else {
                        end = mid;
                    }
                }
                if (leftIdx != -1) {
                    cnt += rightIdx - leftIdx + 1;
                }


            }
        }
        System.out.println(cnt);
    }
}
