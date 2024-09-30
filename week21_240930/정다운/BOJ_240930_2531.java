package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2531 {

    // 벨트 크기, 초밥 가짓수, 연속해서 먹는 접시 수, 쿠폰 번호
    static int N, D, K, C;
    static int[] sushi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for(int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        // STEP 1. 슬라이딩 윈도우

        int calcNumSushi = 0;
        Map<Integer, Integer> spicesOfSushi = new HashMap<>();

        // 초기 셋팅
        int idx = 0;
        for(int i = 0; i < K; i++) {
            if(idx == N)
                idx = 0;

            if(spicesOfSushi.get(sushi[idx]) == null)
                spicesOfSushi.put(sushi[idx], 1);
            else
                spicesOfSushi.put(sushi[idx], spicesOfSushi.get(sushi[idx]) + 1);

            idx++;
        }

        // 쿠폰 번호에 적힌 스시가 없다면?
        if(spicesOfSushi.get(C) == null)
            calcNumSushi = Math.max(calcNumSushi, spicesOfSushi.keySet().size() + 1);
        else
            calcNumSushi = spicesOfSushi.keySet().size();

        int end = idx - 1;
        //System.out.println("초기 end : " + end);

        for(int start = 1; start < N; start++) {

            // 슬라이딩 윈도우!
            end++;
            if(end == N)
                end = 0;

            //System.out.println(start + " : " + end);

            if(spicesOfSushi.get(sushi[start - 1]) > 1)
                spicesOfSushi.put(sushi[start - 1], spicesOfSushi.get(sushi[start - 1]) - 1);
            else
                spicesOfSushi.remove(sushi[start - 1]);

            if(spicesOfSushi.get(sushi[end]) == null)
                spicesOfSushi.put(sushi[end], 1);
            else
                spicesOfSushi.put(sushi[end], spicesOfSushi.get(sushi[end]) + 1);

            // 쿠폰 번호에 적힌 스시가 없다면?
            if(spicesOfSushi.get(C) == null) {
                calcNumSushi = Math.max(calcNumSushi, spicesOfSushi.keySet().size() + 1);
            }
            else
                calcNumSushi = Math.max(calcNumSushi, spicesOfSushi.keySet().size());
        }

        System.out.println(calcNumSushi);
    }
}
