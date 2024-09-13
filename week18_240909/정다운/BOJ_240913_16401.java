package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ16401 {

    static int N, M;
    static int[] snacks;

    public static int findBiggestLeng(int left, int right) {

        int result = 0;

        while(left <= right) {

            int mid = (left + right) / 2;
            int cnt = 0;

            for(int i = 0; i < N; i++)
                cnt += (snacks[i] / mid);


            if(cnt >= M) {
                result = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        snacks = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            snacks[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(snacks);
        int minLeng = 1, maxLeng = snacks[N-1];

        int result = findBiggestLeng(minLeng, maxLeng);
        System.out.println(result);
    }
}
