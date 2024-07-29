package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22862 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int front = 0;
        int back = 0;
        int oddCount = 0;
        int evenCount = 0;
        int answer = 0;

        while (back < N) {
            if (arr[back] % 2 == 1) {
                oddCount++;
            } else {
                evenCount++;
            }

            while (oddCount > K) {
                if (arr[front] % 2 == 1) {
                    oddCount--;
                } else {
                    evenCount--;
                }
                front++;
            }

            answer = Math.max(answer, evenCount);
            back++;
        }

        System.out.println(answer);
    }
}