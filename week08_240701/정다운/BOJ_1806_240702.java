// 투 포인터의 전형적인 문제, 잘 이해하면 투 포인터를 깨우칠 수 있음
// 두 포인터 중, end를 증가시키며 합이 S가 넘어갈 때 까지 증가 & 합이 S보다 작을 때 까지 start 증가

package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1806 {

    static int N;
    static long S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());

        // STEP 2. Implement prefix-sum
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];

        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int lenCnt = Integer.MAX_VALUE;
        int start = 0; int end = 0;
        int Sum = 0;

        while (start < N + 1 && end < N + 1 ) {

            if(Sum < S) {
                Sum += arr[end];
                end++;
            }

            else {
                lenCnt = Math.min(lenCnt, end - start);
                Sum -= arr[start];
                start++;
            }
        }

        if(lenCnt == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(lenCnt);

    }
}
