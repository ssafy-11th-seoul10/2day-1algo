package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ6236 {

    static int N, M;
    static int[] money_schedule;

    public static int check(int price) {

        int tmp = 1;
        int remainder = price;

        for(int todayM : money_schedule) {
            remainder -= todayM;

            if(remainder < 0) {
                ++tmp;
                remainder = price - todayM;
            }
        }

        return tmp;
    }

    public static int lowerCase(int start, int end) {

        while (start < end) {

            int mid = (start + end) / 2;
            int tmp = check(mid);

            //System.out.println(start + ", " + end + ", = " + tmp);

            // 뽑는 갯수가 많으면 더 큰 값 범위로 축소
            if(tmp > M)
                start = mid + 1;
            else
                end = mid;
        }

        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int maxiVal = 0; // 시작점 -> 이걸 잘 못잡아서 틀림..
        money_schedule = new int[N];

        for(int i = 0; i < N; i++) {
            money_schedule[i] = Integer.parseInt(br.readLine());
            maxiVal = Math.max(maxiVal, money_schedule[i]);
        }
        // 어차피, 돈을 가장 많이 쓰는 날 이상의 금액을 인출 해야 한다. ==> 시작점 => 가장 많이 쓰는 날
        int result = lowerCase(maxiVal, 10_000 * 100_000);
        System.out.println(result);
    }
}
