package baekjoon;

import java.util.*;
import java.io.*;

// 매 선택마다 가장 작은 두 카드의 합을 더해가는 것이 그리디함을 보장한다
// 하지만, 매 선택 후 계산한 결과를 배열에 삽입 후, 다시 정렬해서 오름차순을 유지해야 한다.

// 단순 정렬을 쓰면 시간초과 -> 데이터 삽입 & 삭제 & 정렬 빈번하다 -> 우선순위 큐 사용!

public class BOJ1715 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int sum = 0;

        while(pq.size() > 1) {
            int first = pq.poll();
            int twice = pq.poll();

            sum = sum + first + twice;
            pq.add(first + twice);
        }
        System.out.println(sum);

    }
}
