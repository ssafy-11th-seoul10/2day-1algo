package baekjoon;

import java.util.*;
import java.io.*;

// https://velog.io/@ewoo97/BOJ-%EB%B0%B1%EC%A4%80-30804%EB%B2%88-%EA%B3%BC%EC%9D%BC-%ED%83%95%ED%9B%84%EB%A3%A8-JAVA
//두 종류 이하의 과일로 이루어진 가장 긴 연속 부분 수열을 찾아야 한다.
//부분 수열의 길이가 최대가 되도록 해야 한다.

public class BOJ30804 {

    static int N;
    static int[] fruits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fruits = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> fruitsCnt = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        // ** Two Pointer -> right, left = 0에서 시작 **
        for (int right = 0; right < N; right++) {
            // right 포인터에 해당하는 과일에 대한 map 갱신 ( 해당 과일의 개수 + 1 )
            fruitsCnt.put(fruits[right], fruitsCnt.getOrDefault(fruits[right], 0) + 1);

            // 과일 종류가 2개 이하가 될 때 까지
            while (fruitsCnt.size() > 2) {
                // left 포인터에 해당하는 과일에 대한 map 갱신 ( 해당 과일 개수 - 1 )
                fruitsCnt.put(fruits[left], fruitsCnt.get(fruits[left]) - 1);
                // 과일 종류가 사라졌으면 아예 제거
                if (fruitsCnt.get(fruits[left]) == 0) {
                    fruitsCnt.remove(fruits[left]);
                }
                // left 포인터 전진
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    }
}
