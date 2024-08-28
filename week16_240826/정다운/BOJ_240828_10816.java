package baekjoon;

import java.util.*;
import java.io.*;

// lowerBound와 UpperBound의 대표적인 문제!

public class BOJ10816 {

    static int N, M;
    static int[] cards;

    static int[] correctCard;
    static int[] result;

    // upperBound vs lowerBound => 중복 원소에 따라 마지막 idx 위치를 갱신한다.

    public static int lowerBound(int m, int left, int right) {

        if(left >= right) return left;

        int mid = (left + right) / 2;

        if(cards[mid] >= m) // 중복 원소 포함 -> 탐색 범위를 최대한 왼쪽으로 땡긴다.
            return lowerBound(m, left, mid);
        else
            return lowerBound(m, mid+1, right);
    }

    public static int upperBound(int m, int left, int right) {

        if(left >= right) return left;

        int mid = (left + right) / 2;

        if(cards[mid] > m)
            return upperBound(m, left, mid);
        else // 중복원소 포함 -> 최대한 오른쪽으로 탐색 범위를 좁힌다.
            return upperBound(m, mid + 1, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        correctCard = new int[M];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < M; j++)
            correctCard[j] = Integer.parseInt(st.nextToken());

        // correctCard의 입력값에 대해 순차 탐색이 아니라 이분 탐색을 진행한다.
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < M; j++) {

            int headIdx = lowerBound(correctCard[j],0, N);
            int tailIdx = upperBound(correctCard[j],0, N);

            result[j] = tailIdx - headIdx;
            sb.append(result[j]).append(" ");
        }

        System.out.println(sb);

    }
}
